package com.zyh.reflection;

import javax.security.auth.callback.Callback;
import java.util.concurrent.*;

/*
  Callable + Future获取执行结果
 */
public class Test {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executorService.submit(task);
        executorService.shutdown();

        Thread.sleep(1000);
        System.out.println("主线程正在执行任务");

        System.out.println("task执行结果为：" + result.get());//取值的时候发生了阻塞
        System.out.println("所有任务都执行结束");

    }


}

class Task implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在进行计算");

        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
        {
            sum += i;
        }
        return sum;
    }
}
