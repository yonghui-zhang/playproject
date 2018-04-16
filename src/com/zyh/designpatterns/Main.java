package com.zyh.designpatterns;

public class Main {

    public static void main(String[] args)
    {
       SDKDownloadSubject sdkDownloadSubject = new SDKDownloadSubject();
       Observer observer = new ProgramMonkeyObserver();
       Observer observer1 = new ProgramMonkeyObserver();
       sdkDownloadSubject.attach(observer);
       sdkDownloadSubject.attach(observer1);

       sdkDownloadSubject.netProcessChange("1%");
       sdkDownloadSubject.netProcessChange("51%");
       sdkDownloadSubject.netProcessChange("100%");

    }
}
