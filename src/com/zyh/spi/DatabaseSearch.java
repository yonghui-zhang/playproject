package com.zyh.spi;

public class DatabaseSearch implements Search{

    @Override
    public void search() {
        System.out.println("数据库搜索");
    }
}
