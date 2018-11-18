package com.cxx.log;

import com.cxx.log.format.CommonFormat;
import com.cxx.log.format.JsonFormat;

/**
 * User: lanxinghua
 * Date: 2018/11/18 19:49
 * Desc:
 */
public class AbstractLogUtil {
    /**
     * 格式化log
     *
     * @param logFormat
     * @return
     */
    public static String formatLog(LogFormat logFormat) {
        return (logFormat != null) ? logFormat.log() : "";
    }

    //[业务日志]。aaaa
    public static String common(String title, String format, Object... params) {
        if (params.length == 0) {
            return formatLog(CommonFormat.title(title).content(format));
        } else {
            return formatLog(CommonFormat.title(title).content(format, params));
        }
    }

    //[业务异常]。json:[{"id":1,"name":"小明"}]
    public static String json(String title, Object... message) {
        return formatLog(JsonFormat.title(title).obj(message));
    }



    public static void main(String[] args) {
        String msg = json("title", "666");
        System.out.println(msg);

    }

}
