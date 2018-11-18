package com.cxx.log;

import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:59
 * Desc: 可自定义LogUtil，继承此类
 */
public class BaseLogUtils extends AbstractLogUtil{
    public static final Logger LOGGER = LoggerFactory.getLogger(BaseLogUtils.class);
    public static final String LOG_TITLE_SYS = "系统异常";
    public static final String LOG_TITLE_BUSINESS = "业务异常";
    public static final String LOG_TITLE_SERVICE = "服务调用异常";
    public static final String LOG_TITLE_AUTH = "安全认证异常";
    public static final String LOG_TITLE_ACCESS = "请求日志";
    public static final String LOG_TITLE_SLOW_ACCESS = "请求慢日志";
    public static final String LOG_TITLE_VERIFY = "校验失败";
    public static final Logger LONGTIME = LoggerFactory.getLogger("longTime");
    public static final Logger ACCESS = LoggerFactory.getLogger("access");

    public static void main(String[] args) {
        Map<String, Object> map = new HashedMap();
        map.put("id", 1);
        map.put("name", "小明");
        System.out.println(json(LOG_TITLE_BUSINESS, map));
        LOGGER.info("这个{}鬼，危机诶高级{}", "xxxx", "xxxx");
    }
}
