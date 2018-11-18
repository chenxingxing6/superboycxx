package com.cxx.result;

import org.apache.commons.lang3.StringUtils;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:14
 * Desc:
 */
public class ResultSupport<T> implements Result<T> {

    private boolean success = true;
    private String resultCode;
    private String message;
    private T model;
    private int totalRecord;

    public ResultSupport() { }

    public ResultSupport(boolean success) {
        this.success = success;
    }

    public ResultSupport(boolean success,String resultCode,String message){
        this.success = success;
        this.resultCode = resultCode;
        this.message = message;
    }

    public ResultSupport(String resultCode,String message){
        this.success = Boolean.FALSE;
        this.resultCode = resultCode;
        this.message = message;
    }
    public ResultSupport(ResultCode resultCode){
        this.success = false;
        this.resultCode = resultCode.getCode();
        this.message = resultCode.getMessage();
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }


    @Override
    public void setSuccess(boolean success) {
        this.success = success;
    }

    @Override
    public boolean isSuccess() {
        return success;
    }

    @Override
    public String getResultCode() {
        if (!isSuccess() && StringUtils.isBlank(resultCode)){
            return BaseResultCode.SYSTEM.getCode();
        }
        return resultCode;
    }

    @Override
    public void setResultCode(String code) {

    }

    @Override
    public T getModel() {
        return model;
    }

    @Override
    public void setModel(T model) {

    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }
}
