package com.cxx.result;

import com.cxx.result.ResultCode;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:20
 * Desc:
 */
public enum BaseResultCode implements ResultCode {
    SYSTEM("E_001", "系统异常"),
    ADD("E_002", "添加异常"),
    DEL("E_003", "删除异常"),
    UPDATE("E_004", "修改异常")
    ;

    BaseResultCode(String code, String message){
        this.code = code;
        this.message = message;
    }


    private String code;
    private String message;

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
