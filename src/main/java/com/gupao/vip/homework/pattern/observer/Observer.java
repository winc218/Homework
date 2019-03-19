package com.gupao.vip.homework.pattern.observer;


import com.gupao.vip.homework.pattern.observer.core.Event;

public class Observer {
    public void advice( Event e) {
        System.out.println("=================触发事件，打印日志================\n" + e);
    }
}
