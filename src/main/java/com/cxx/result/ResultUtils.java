package com.cxx.result;

import org.apache.commons.collections.map.LinkedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:09
 * Desc: Result结果处理
 */
public class ResultUtils {
    private static final Logger logger = LoggerFactory.getLogger(ResultUtils.class);
    private static final String INVOKE_INFO = "invokeInfo";
    private static final String MESSAGE = "message";
    private static final String PROVIDER_IP = "providerIp";
    private static final String CONSUMER_IP = "consumerIp";
    private static final String PROVIDER_HOST_NAME = "providerHostName";
    private static final String CONSUMER_HOST_NAME = "consumerHostName";
    private static final String EXCEPTION_NAME = "invoke remote service error";
    private static final String DUBBO_VERSION = "dubbo_version";
    private static final String P_VERSION = "version";

    public static <T> T handleResultAllowNull(Result<T> result){
        return handleResult(result, true);
    }

    public static <T> T handleResultRefuseNull(Result<T> result, String serviceName) {
        return handleResult(result, false);
    }

    private static <T> T handleResult(Result<T> result, boolean allowModelNull){
        if (result == null){
            String errMsg = "result is null";
            log(errMsg);
            throw new RuntimeException("系统异常!");
        }
        if (!result.isSuccess()) {
            log(result.getMessage());
            throw new RuntimeException(result.getMessage());
        }
        T model = result.getModel();
        if (!allowModelNull && model == null) {
            log("data not found");
            throw new RuntimeException("获取失败!");
        }
        return model;
    }


    private static void log(String message) {
        Map<String, Object> printInfo = new LinkedMap(16);
        printInfo.put(MESSAGE, message);
        printInfo.put(DUBBO_VERSION,"");
        printInfo.put(INVOKE_INFO, "");
        printInfo.put(PROVIDER_IP, "");
        printInfo.put(PROVIDER_HOST_NAME, "");
        printInfo.put(CONSUMER_IP, "");
        printInfo.put(CONSUMER_HOST_NAME, "");
        logger.error(printInfo.toString());
    }
}
