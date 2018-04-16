package com.zyh.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

public class Class1 {

    private int timeout = 0;

    private Class2 class2 = new Class2();

    public Class2 getClass2()
    {
        return class2;
    }
    //默认构造方法
    public Class1()
    {

    }
    //构造方法1
    public Class1(int timeout, int hello)
    {
        this.timeout = timeout;
        this.class2.setHello(hello);
    }

    //构造方法2
    public Class1(int timeout, int param1, int param2)
    {

    }
    //构造方法3
  //  public Class1(int timeout, int param1)
  //  {

  //  }

    public int getTimeout()
    {
        return timeout;
    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class1 class1 = new Class1(300, 100);
        System.out.println("原来class1的编号：" + class1);
        System.out.println("原来class2的编号：" + class1.getClass2());
        System.out.println("原来timeout= " + class1.getTimeout());
        System.out.println("原来hello= " + class1.getClass2().getHello());
        //利用反射注入
  //      Class class2 = Class1.class;
    //    for(Constructor constructor : class2.getConstructors())
     //   {
      //      System.out.println(constructor);
     //   }

     //  Constructor c = class2.getConstructor();
   //     Constructor c2 = class2.getConstructor(int.class);
    //    Class1 c1 = (Class1) c2.newInstance(200);
   //     System.out.println("改变后：" + c1);
   //     System.out.println(c1.getTimeout());
       Class<? extends Class1> clazz = class1.getClass();
       Field[]  fields = clazz.getDeclaredFields();
       for(Field field : fields)
       {
           String fieldName = field.getName();
           int m = field.getModifiers();
           String mStr = Modifier.toString(m);
           System.out.println(fieldName + "属性" + mStr);
       }

       Field timeoutField = clazz.getDeclaredField("timeout");
       timeoutField.setAccessible(true);
       timeoutField.set(class1, 800);


      ;
       Field field = clazz.getDeclaredField("class2").getClass().getDeclaredField("hello");
       field.setAccessible(true);
       field.set(clazz.getDeclaredField("class2"), 900);

        System.out.println("反射修改完class1的编号：" + class1);
        System.out.println("反射修改后timeout= " + class1.getTimeout());
        System.out.println("反射修改后hello=" + class1.getClass2().getHello());
    }
}
