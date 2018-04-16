package com.zyh.designpatterns.observerpattern3;

import java.util.Observable;

public class SDKDownloadObservable extends Observable{

    private String mState;

    public String getState()
    {
        return mState;
    }

    public void netProcessChange(String data)
    {
       mState = data;
       this.setChanged();
       this.notifyObservers();
    }
}
