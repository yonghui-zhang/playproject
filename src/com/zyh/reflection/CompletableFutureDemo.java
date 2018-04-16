package com.zyh.reflection;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class CompletableFutureDemo {

    public static void main(String[] args)
    {
        CompletableFuture<Double> futurePrice = getPriceAsync();

        System.out.println(111);
        futurePrice.whenComplete((aDouble, throwable) -> {
            System.out.println(aDouble);
        });

        System.out.println(222);
    }

    static CompletableFuture<Double> getPriceAsync()
    {
        CompletableFuture<Double> futurePrice = new CompletableFuture<>();
   //     CompletableFuture<Double> futurePrice = CompletableFuture.supplyAsync(()->
     //           {
                    new Thread(() ->{

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        futurePrice.complete(23.55);
                    }).start();
//                }
     //   );

        return futurePrice;

    }

}
