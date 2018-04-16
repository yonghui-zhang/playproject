package com.zyh.reflection;

public class LambdaDemo {

    public static void main(String[] args)
    {
        Runnable runnable = () -> System.out.println("hello lambda");
     //   new Thread(runnable).start();
        new Thread(
                () -> System.out.println("hello Lambda")
        ).start();
    }
}
