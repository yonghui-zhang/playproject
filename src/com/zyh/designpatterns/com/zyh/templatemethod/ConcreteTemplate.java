package com.zyh.designpatterns.com.zyh.templatemethod;

public class ConcreteTemplate extends AbstractTemplate{


    /*
     * 必须实现的方法
     */
    @Override
    public void abstractMethod() {

         /* 实现一些具体的逻辑  */
        System.out.println("实现一些具体的逻辑");
    }

    @Override
    public void hookMethod() {

        /* 实现一些hook逻辑或者不实现 */
        System.out.println("实现一些hook逻辑或者不实现");
    }


    public static void main(String[] args)
    {
       ConcreteTemplate ct = new ConcreteTemplate();
       ct.templateMethod();
    }
}
