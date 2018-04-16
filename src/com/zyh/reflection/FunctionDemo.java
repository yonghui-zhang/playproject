package com.zyh.reflection;

import java.util.function.Function;

public class FunctionDemo {

    public static void modityTheValue(int valueToBeOperate, Function<Integer, Integer> function)
    {
        int newValue = function.apply(valueToBeOperate);
        System.out.println(newValue);

    }
    public static void main(String[] args)
    {
       int incr = 20;
       int myNumber = 10;
       modityTheValue(myNumber, number -> number + incr);
    }
}
