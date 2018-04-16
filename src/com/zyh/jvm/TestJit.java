package com.zyh.jvm;

public class TestJit {

    public static int i = 0;

    public static void addFunc()
    {
        i++;
    }
    public static void main(String[] args)
    {

        for(int i=0;i<1600;i++)
        {
            addFunc();
        }
    }
}
