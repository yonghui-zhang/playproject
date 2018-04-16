package com.zyh.designpatterns.ObserverPattern2;

public class SDKDownloadSubject extends Subject{

    private String mState;

    public String getState()
    {
        return mState;
    }

    public void netProcessChange(String data)
    {
         mState = data;
         this.motifyObserver();
    }
}
