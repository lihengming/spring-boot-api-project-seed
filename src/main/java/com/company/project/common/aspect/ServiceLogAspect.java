package com.company.project.common.aspect;

import com.company.project.common.annotations.ServiceLog;
import com.company.project.common.util.LogAspectUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * Description:
 * service 日志记录切面
 *
 * @author LErry.li
 * Date: 2018-06-17
 * Time: 14:47
 */
@Aspect
@Component
public class ServiceLogAspect {

    private final Logger logger = LoggerFactory.getLogger(ServiceLogAspect.class);

    /**
     * 环绕通知方法
     * @param joinPoint 连接点
     * @return 切入点返回值
     * @throws Throwable 异常信息
     */
    @Around("@within(com.company.project.common.annotations.ServiceLog) ||@annotation(com.company.project.common.annotations.ServiceLog)")
    public Object doServiceLog(ProceedingJoinPoint joinPoint)  throws Throwable{
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        // 拦截的实体类
        Object target = joinPoint.getTarget();
        // 拦截的方法名称
        String methodName = signature.getName();
        // 拦截的放参数类型
        Class[] parameterTypes = signature.getMethod().getParameterTypes();

        Method method = target.getClass().getMethod(methodName, parameterTypes);
        if(null == method){
            return joinPoint.proceed();
        }
        // 判断是否包含自定义的注解
        if (!method.isAnnotationPresent(ServiceLog.class)) {
            return joinPoint.proceed();
        }
        String methodParams = LogAspectUtil.getMethodParams(joinPoint);
        logger.info("开始请求方法:[{}] 参数:[{}]", methodName, methodParams);
        long start = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        String deleteSensitiveContent =  LogAspectUtil.deleteSensitiveContent(result);
        logger.info("结束请求方法:[{}] 参数:[{}] 返回结果[{}] 耗时:[{}]毫秒 ",
                methodName, methodParams, deleteSensitiveContent, end - start);
        return result;
    }

    /**
     * 获取注解中对方法的描述信息 用于service层注解
     * @param joinPoint
     * @return
     */
    private String getServiceMethodDescription(ProceedingJoinPoint joinPoint){
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = null;
        try {
            targetClass = Class.forName(targetName);
        } catch (ClassNotFoundException e) {
            throw new ClassCastException();
        }
        Method[] methods = targetClass.getMethods();
        String description = "";
        for(Method method : methods) {
            if(method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if(clazzs.length == arguments.length && null != method.getAnnotation(ServiceLog.class)) {
                    description = method.getAnnotation(ServiceLog.class).description();
                    break;
                }
            }
        }
        return description;
    }

}
