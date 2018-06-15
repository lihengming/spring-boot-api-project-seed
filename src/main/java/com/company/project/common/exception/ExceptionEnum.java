package com.company.project.common.exception;

import com.company.project.common.result.ResultCode;
import org.springframework.http.HttpStatus;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  异常、HTTP状态码、默认自定义返回码 映射类
 * @author LErry.li
 * Date: 2018-06-15
 * Time: 14:41
 */
public enum ExceptionEnum {
    /**
     * 无效参数
     */
    PARAMETER_INVALID(ParameterInvalidException.class, HttpStatus.BAD_REQUEST, ResultCode.PARAM_IS_INVALID),

    /**
     * 数据未找到
     */
    NOT_FOUND(DataNotFoundException.class, HttpStatus.NOT_FOUND, ResultCode.RESULE_DATA_NONE),

    /**
     * 数据已存在
     */
    CONFLICT(DataConflictException.class, HttpStatus.CONFLICT, ResultCode.DATA_ALREADY_EXISTED),

    /**
     * 用户未登录
     */
    UNAUTHORIZED(UserNotLoginException.class, HttpStatus.UNAUTHORIZED, ResultCode.USER_NOT_LOGGED_IN),

    /**
     * 无访问权限
     */
    FORBIDDEN(PermissionForbiddenException.class, HttpStatus.FORBIDDEN, ResultCode.PERMISSION_NO_ACCESS),

    /**
     * 远程访问时错误
     */
    REMOTE_ACCESS_ERROR(RemoteAccessException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.INTERFACE_OUTTER_INVOKE_ERROR),

    /**
     * 系统内部错误
     */
    INTERNAL_SERVER_ERROR(InternalServerException.class, HttpStatus.INTERNAL_SERVER_ERROR, ResultCode.SYSTEM_INNER_ERROR);

    private Class<? extends BusinessException> eClass;

    private HttpStatus httpStatus;

    private ResultCode resultCode;

    /**
     * @param eClass
     * @param httpStatus
     * @param resultCode
     */
    ExceptionEnum(Class<? extends BusinessException> eClass, HttpStatus httpStatus, ResultCode resultCode) {
        this.eClass = eClass;
        this.httpStatus = httpStatus;
        this.resultCode = resultCode;
    }

    public Class<? extends BusinessException> getEClass() {
        return eClass;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }

    public static boolean isSupportHttpStatus(int httpStatus) {
        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            if (exceptionEnum.httpStatus.value() == httpStatus) {
                return true;
            }
        }

        return false;
    }

    public static boolean isSupportException(Class<?> z) {
        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            if (exceptionEnum.eClass.equals(z)) {
                return true;
            }
        }

        return false;
    }

    public static ExceptionEnum getByHttpStatus(HttpStatus httpStatus) {
        if (httpStatus == null) {
            return null;
        }

        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            if (httpStatus.equals(exceptionEnum.httpStatus)) {
                return exceptionEnum;
            }
        }

        return null;
    }

    public static ExceptionEnum getByEClass(Class<? extends BusinessException> eClass) {
        if (eClass == null) {
            return null;
        }

        for (ExceptionEnum exceptionEnum : ExceptionEnum.values()) {
            if (eClass.equals(exceptionEnum.eClass)) {
                return exceptionEnum;
            }
        }

        return null;
    }
}
