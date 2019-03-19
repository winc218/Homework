package com.gupao.vip.homework.pattern.observer;


import com.gupao.vip.homework.pattern.observer.core.Event;

import java.lang.reflect.Method;

public class ObserverTest {
    public static void main( String[] args ) throws NoSuchMethodException {
        Observer observer = new Observer();
        final Method advice = Observer.class.getMethod( "advice", Event.class );


        Subscriber subscriber = new Subscriber();
        subscriber.addListener( SubscribeEventType.ON_ADD, observer, advice );
        subscriber.add();
    }
}
