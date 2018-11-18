package com.cxx.log.template;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:05
 * Desc:
 */
public class ErrorMsgTemplate {
    private String message;
    private String uri;
    private Map params;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
