package com.zyh.annotation;

@ClassAnnotation
public class TestAnnotation {

    @FieldAnnotation(value = "老伯", operate = "啥都不干！")
    public String operate;

    @MethodAnnotation(value = "好人", name = "老伯")
    public void testMethod()
    {
        System.out.println("这个测试方法！");
    }
}
