package com.zyh.designpatterns.ObserverPattern2;

public class ProgramMonkeyObserver implements Observer{


    @Override
    public void update(Subject subject) {
        String state = ((SDKDownloadSubject)subject).getState();
        System.out.println("Programer look the SDK download process is: " + state);
    }
}
