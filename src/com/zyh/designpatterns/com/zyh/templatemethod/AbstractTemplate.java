package com.zyh.designpatterns.com.zyh.templatemethod;

public abstract class AbstractTemplate {

    /*
     * 模板方法，起到模板作用
     */
    public final void templateMethod()
    {
         abstractMethod();
         hookMethod();
         concreteMethod();
    }

    /*
     * 基本方法的声明(必须实现)
     */
    public abstract void abstractMethod();



    /*
     * 基本方法的空实现（可用于hook）
     */
    public void hookMethod()
    {

    }

    /*
     * 子类不可变方法（实现一些固定的逻辑）
     */
    private void concreteMethod()
    {
        System.out.println("抽象类中实现一些固定的逻辑");
    }


}
