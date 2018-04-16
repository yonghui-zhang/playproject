package com.zyh.reflection;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.InvocationTargetException;

public class BeanUtilsDemo {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {

        Class1 class1 = new Class1(300, 100);
        System.out.println("原来class1的编号：" + class1);
        System.out.println("原来class2的编号：" + class1.getClass2());
        System.out.println("原来timeout= " + class1.getTimeout());
        System.out.println("原来hello= " + class1.getClass2().getHello());
        System.out.println("原来key= " + class1.getClass2().getClass3().getKey());

        BeanUtils.setProperty(class1, "class2.class3.key", "1000");


        System.out.println("反射修改完class1的编号：" + class1);
        System.out.println("反射修改后timeout= " + class1.getTimeout());
        System.out.println("反射修改后hello=" + class1.getClass2().getHello());
        System.out.println("反射修改后key= " + class1.getClass2().getClass3().getKey());

    }


}
