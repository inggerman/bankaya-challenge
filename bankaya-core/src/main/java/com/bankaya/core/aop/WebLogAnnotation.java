package com.bankaya.core.aop;

import com.bankaya.core.enums.WebMethodEnum;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE })
@Retention(RUNTIME)
@Documented
public @interface WebLogAnnotation {

    String originIp();
    WebMethodEnum webMethod();
}


