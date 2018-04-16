package com.zyh.reflection;

public class Class2 {
    private int hello = 10;
    private Class3 class3 = new Class3();

    public int getHello()
    {
        return hello;
    }
    public void setHello(int hello)
    {
        this.hello = hello;
    }

    public Class3 getClass3()
    {
        return class3;
    }
}
