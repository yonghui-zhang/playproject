package com.zyh.reflection;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CompletableFutureDemo2 {

    public static void main(String[] args)
    {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletableFuture<String> future = CompletableFuture.supplyAsync(

                () -> {
                    System.out.println("task start");
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return "task completed";
                }, executorService
        );

        future.thenAccept(e -> System.out.println(e + " ok !"));

        System.out.println("main thread is running");
    }
}
