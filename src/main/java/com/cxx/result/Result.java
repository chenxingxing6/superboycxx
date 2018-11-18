package com.cxx.result;

import java.io.Serializable;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:11
 * Desc:
 */
public interface Result<T> extends Serializable {
    void setSuccess(boolean success);

    boolean isSuccess();

    String getResultCode();

    void setResultCode(String code);

    T getModel();

    void setModel(T model);

    public String getMessage();

    public void setMessage(String message);
}
