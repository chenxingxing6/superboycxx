package com.cxx.validate.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * User: lanxinghua
 * Date: 2018/11/18 20:55
 * Desc:
 */
@java.lang.annotation.Target({ElementType.METHOD})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface Validator {

    public Check[] value() default {};
}
