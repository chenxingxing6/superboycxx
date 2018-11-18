package com.cxx.result;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:24
 * Desc:
 */
public class ResultMap<T> extends LinkedHashMap {
    public static final String CODE = "code";       //接口调用是否成功，0：失败，1：成功
    public static final String ERROR_CODE = "errorCode";   //业务编码 接口调用错误业务编码
    public static final String DATA = "data";       //数据对象 成功需要返回消息，在data里加一个属性（比如：“showMsg”）
    public static final String RECORD = "record";   //记录条数，当查询列表时接口返回的记录条数
    public static final String MESSAGE = "message"; //错误消息内容

    public static final int ERROR = 0;  //异常
    public static final int SUCCESS = 1;//成功


    public ResultMap() {
        put(CODE, SUCCESS);

    }


    public ResultMap(T t){
        put(CODE, SUCCESS);
        if (t instanceof Result){
            Result result = (Result)t;
            if (!result.isSuccess()) {
                this.put("code", 0);
                this.put("errorCode", result.getResultCode());
                this.put("message", result.getMessage());
            }else {
                this.put("data", result.getModel());
            }
        }else if (t instanceof Map){
            this.putAll((Map)t);
        }else {
            put(DATA, t);
        }
    }

    public ResultMap(String errorCode, String message){
        put(CODE, ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);
    }

    public ResultMap(String errorCode, String message, T t) {
        this(t);
        put(CODE, ERROR);
        put(ERROR_CODE, errorCode);
        put(MESSAGE, message);
    }

    public ResultMap(boolean success) {
        put(CODE, success ? SUCCESS : ERROR);
    }

    public void setSuccess(boolean success) {
        put(CODE, success ? SUCCESS : ERROR);
    }

    public void setErrorCode(String errorCode) {
        put(ERROR_CODE, errorCode);
    }

    public void setMessage(String message) {
        put(MESSAGE, message);
    }

    public void setData(T t) {
        put(DATA, t);
    }

}
