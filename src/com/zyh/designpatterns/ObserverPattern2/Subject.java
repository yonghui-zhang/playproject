package com.zyh.designpatterns.ObserverPattern2;

import java.util.ArrayList;
import java.util.List;

public class Subject {

    private List<Observer> list = new ArrayList<Observer>();

    public void attach(Observer observer)
    {
        list.add(observer);
    }

    public void detach(Observer observer)
    {
        list.remove(observer);
    }

    public void motifyObserver()
    {
        for (Observer observer : list)
        {
            observer.update(this);
        }
    }

}
