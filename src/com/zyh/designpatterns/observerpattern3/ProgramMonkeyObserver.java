package com.zyh.designpatterns.observerpattern3;

import java.util.Observable;
import java.util.Observer;

public class ProgramMonkeyObserver implements Observer{

    public ProgramMonkeyObserver(Observable obs)
    {
        obs.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Programer look the SDK download process is: "+((SDKDownloadObservable)o).getState());
    }
}
