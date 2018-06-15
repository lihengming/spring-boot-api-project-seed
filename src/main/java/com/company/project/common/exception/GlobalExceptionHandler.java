package com.company.project.common.exception;

import com.company.project.common.result.DefaultErrorResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  统一异常处理器
 * @author LErry.li
 * Date: 2018-06-15
 * Time: 14:41
 */
@RestController
@ControllerAdvice
public class GlobalExceptionHandler extends BaseGlobalExceptionHandler {

    /**
     * 处理400类异常
     * @param e
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    @Override
    public DefaultErrorResult handleConstraintViolationException(ConstraintViolationException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    @Override
    public DefaultErrorResult handleConstraintViolationException(HttpMessageNotReadableException e, HttpServletRequest request) {
        return super.handleConstraintViolationException(e, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BindException.class)
    @Override
    public DefaultErrorResult handleBindException(BindException e, HttpServletRequest request) {
        return super.handleBindException(e, request);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @Override
    public DefaultErrorResult handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
        return super.handleMethodArgumentNotValidException(e, request);
    }

    /**
     * 处理自定义异常
     * @param e
     * @param request
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @Override
    public ResponseEntity<DefaultErrorResult> handleBusinessException(BusinessException e, HttpServletRequest request) {
        return super.handleBusinessException(e, request);
    }


    /**
     * 处理运行时异常
     * @param e
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RuntimeException.class)
    @Override
    public DefaultErrorResult handleRuntimeException(RuntimeException e, HttpServletRequest request) {
        //TODO 可通过邮件、微信公众号等方式发送信息至开发人员、记录存档等操作
        return super.handleRuntimeException(e, request);
    }
}
