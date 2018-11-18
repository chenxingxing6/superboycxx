package com.cxx.log.format;

import com.cxx.log.AbstractLogFormat;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:50
 * Desc:
 */
public class CommonFormat extends AbstractLogFormat {
    /**
     * 一串文本内容
     */
    private String content;

    public static CommonFormat title(String title) {
        return new CommonFormat(title);
    }

    public CommonFormat content(String content) {
        this.content = content;
        return this;
    }

    //{}替换
    public CommonFormat content(String format, Object[] params) {
        this.content = String.format(format.replaceAll("\\{}", "%s"), params);
        return this;
    }


    private CommonFormat(String title) {
        super(title);
    }

    @Override
    protected String buildLogMsg() {
        return content;
    }
}
