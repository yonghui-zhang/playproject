package com.zyh.reflection;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaDemo2 {

    public static void main(String[] args)
    {
        List<Integer> list = Arrays.asList(1,2,3,4);
  //      for(Integer integer: list)
  //      {
  //          System.out.println(integer);
   //     }

//        list.forEach((integer) -> System.out.println(integer));
//
//        Supplier<String> supplier = () -> "周添华，我喜欢你";
//        System.out.println(supplier.get());

        Predicate<String> predicate = (周添华) -> 周添华.length() > 0;
        System.out.println(predicate.test("周添华"));
    }
}
