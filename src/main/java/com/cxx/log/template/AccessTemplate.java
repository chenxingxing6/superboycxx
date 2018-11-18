package com.cxx.log.template;

import com.alibaba.fastjson.JSON;

import java.util.Map;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:06
 * Desc:
 */
public class AccessTemplate {
    private String uri;
    private String invokeId;
    private String userId;
    private Map params;
    private Map header;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getInvokeId() {
        return invokeId;
    }

    public void setInvokeId(String invokeId) {
        this.invokeId = invokeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Map getParams() {
        return params;
    }

    public void setParams(Map params) {
        this.params = params;
    }

    public Map getHeader() {
        return header;
    }

    public void setHeader(Map header) {
        this.header = header;
    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}
