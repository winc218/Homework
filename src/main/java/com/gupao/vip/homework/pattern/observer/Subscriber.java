package com.gupao.vip.homework.pattern.observer;


import com.gupao.vip.homework.pattern.observer.core.EventListener;

public class Subscriber extends EventListener {
    // 通常采用动态代理实现监控，避免代码侵入
    public void add() {
        System.out.println("调用一个添加的方法");
        trigger( SubscribeEventType.ON_ADD );
    }

    public void remove() {
        System.out.println("调用一个删除的方法");
        trigger( SubscribeEventType.ON_REMOVE );
    }
}
