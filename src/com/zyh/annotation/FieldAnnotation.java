package com.zyh.annotation;

import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface FieldAnnotation {

    String value() default "I am Field Annotation";

    String operate() default "operate";
}
