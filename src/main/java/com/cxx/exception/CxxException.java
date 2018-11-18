package com.cxx.exception;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:46
 * Desc:
 */
public class CxxException extends RuntimeException{
    private String code;
    public CxxException(){
        super();
    }

    public CxxException(final String code,final String message, final Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public CxxException(final String message) {
        super(message);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
