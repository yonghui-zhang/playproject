package com.zyh.reflection;

public class WorkerInterfaceTest {

    public static void execute(WorkerInterface workerInterface)
    {
        workerInterface.doSomeWork();
    }
    public static void main(String[] args)
    {
        execute(new WorkerInterface() {
            @Override
            public void doSomeWork() {
                System.out.println("11111");
            }
        });
        //Lambda表达式用法
        execute(
                () -> System.out.println("2222")
        );
    }
}
