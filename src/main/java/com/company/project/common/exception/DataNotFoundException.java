package com.company.project.common.exception;


import com.company.project.common.result.ResultCode;

/**
 * Created with IntelliJ IDEA.
 * Description:
 *  数据未找到
 * @author LErry.li
 * Date: 2018-06-15
 * Time: 14:41
 */
public class DataNotFoundException extends BusinessException {
    private static final long serialVersionUID = 3721036867889297081L;

    public DataNotFoundException() {
        super();
    }

    public DataNotFoundException(Object data) {
        super();
        super.data = data;
    }

    public DataNotFoundException(ResultCode resultCode) {
        super(resultCode);
    }

    public DataNotFoundException(ResultCode resultCode, Object data) {
        super(resultCode, data);
    }

    public DataNotFoundException(String msg) {
        super(msg);
    }

    public DataNotFoundException(String formatMsg, Object... objects) {
        super(formatMsg, objects);
    }

}
