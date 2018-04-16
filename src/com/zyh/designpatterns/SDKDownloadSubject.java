package com.zyh.designpatterns;

public class SDKDownloadSubject extends Subject {

    public void netProcessChange(String data)
    {
        this.motifyObservers(data);
    }
}
