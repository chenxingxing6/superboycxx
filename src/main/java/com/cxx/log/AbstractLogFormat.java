package com.cxx.log;

import org.apache.commons.lang3.StringUtils;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:46
 * Desc:
 */
public abstract class AbstractLogFormat implements LogFormat {
    //日志标题
    protected String title;

    public AbstractLogFormat(String title){
        this.title = title;
    }

    private String getTitle(){
        StringBuilder sb = new StringBuilder(32);
        if (StringUtils.isNotBlank(title)) {
            sb.append("[").append(title).append("]。");
        }
        return sb.toString();
    }

    @Override
    public String log() {
        return getTitle()+ buildLogMsg();
    }

    /**
     * 子类实现
     * @return
     */
    protected abstract String buildLogMsg();
}
