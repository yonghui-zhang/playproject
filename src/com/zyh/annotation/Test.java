package com.zyh.annotation;

import com.zyh.reflection.Class3;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Test {


    public static void main(String[] args) throws ClassNotFoundException {

       Class clazz = Class.forName("com.zyh.annotation.TestAnnotation");
       Method[] methods = clazz.getMethods();

       boolean flag = clazz.isAnnotationPresent(ClassAnnotation.class);
       if (flag)
       {
           ClassAnnotation classAnnotation = (ClassAnnotation) clazz.getAnnotation(ClassAnnotation.class);
           System.out.println(classAnnotation.value());
       }
       boolean methodFlag = methods[0].isAnnotationPresent(MethodAnnotation.class);
       if (methodFlag)
       {
           MethodAnnotation methodAnnotation = methods[0].getAnnotation(MethodAnnotation.class);
           System.out.println(methodAnnotation.name() + methodAnnotation.value());
       }

       Field[] fields = clazz.getDeclaredFields();
       boolean fieldFlag = fields[0].isAnnotationPresent(FieldAnnotation.class);
       if (fieldFlag)
       {
           FieldAnnotation fieldAnnotationm = fields[0].getAnnotation(FieldAnnotation.class);
           System.out.println(fieldAnnotationm.value());
       }

    }
}
