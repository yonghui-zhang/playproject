package com.zyh.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface MethodAnnotation {

    String value() default "I am Field Annotation";

    String name() default "laobo";
}
