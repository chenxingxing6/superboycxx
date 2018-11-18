package com.cxx.log.format;

import com.alibaba.fastjson.JSON;
import com.cxx.log.AbstractLogFormat;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:53
 * Desc:
 */
public class JsonFormat extends AbstractLogFormat {
    private static final String JSON_FORMAT = "json:";

    private Object[] obj;

    private JsonFormat(String title) {
        super(title);
    }

    public static JsonFormat title(String title) {
        return new JsonFormat(title);
    }

    public JsonFormat obj(Object... obj) {
        this.obj = obj;
        return this;
    }

    @Override
    protected String buildLogMsg() {
        return JSON_FORMAT + (obj == null? "{}" : JSON.toJSONString(obj));
    }

}
