package com.cxx.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:55
 * Desc:
 */
    @Target(ElementType.PARAMETER)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Check {

        /**
         * @return
         */
        double[] v() default {};

        Class<? extends Enum> c() default Enum.class;

        /**
         * 需要验证的参数名字，不设置按check所在的索引匹配参数
         *
         * @return
         */
        String name() default "";

        /**
         * 错误编码
         *
         * @return
         */
        String errorCode() default "0";

        /**
         * 错误内容
         *
         * @return
         */
        String message() default "";

}
