package com.zyh.designpatterns;

public class ProgramMonkeyObserver implements Observer{


    @Override
    public void update(String state) {
        System.out.println("Programer look the SDK download process is " + state);
    }
}
