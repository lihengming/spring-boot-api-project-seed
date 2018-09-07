package com.company.project.core;

/**
 * 响应码枚举，参考微信全局返回码说明
 */
public enum ResultCode {
    SUCCESS(0),//请求成功
    FAIL(40000),//请求失败(比如请求参数不匹配，请求body之类的错误)
    UNAUTHORIZED(40001),//未认证（签名错误）
    NOT_FOUND(40004),//接口不存在
    INTERNAL_SERVER_ERROR(-1);//服务器内部错误,系统繁忙

    private final int code;

    ResultCode(int code) {
        this.code = code;
    }

    public int code() {
        return code;
    }
}
