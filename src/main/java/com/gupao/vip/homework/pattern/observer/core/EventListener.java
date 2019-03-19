package com.gupao.vip.homework.pattern.observer.core;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class EventListener {

    protected Map<Enum, Event> events = new HashMap<>(  );

    public void addListener(Enum eventType, Object target, Method callback) {
        // 注册事件
        // 用反射调用这个方法
        events.put( eventType, new Event( target, callback ) );
    }

    protected void trigger(Enum eventType) {
        if(!this.events.containsKey( eventType )) {
            return;
        }
        trigger( this.events.get(eventType).setTrigger( eventType.toString() ) );
    }

    private void trigger(Event e) {
        e.setSource( this );
        try {
            e.getCallback().invoke( e.getTarget(), e );
        } catch ( IllegalAccessException | InvocationTargetException e1 ) {
            e1.printStackTrace();
        }
    }
}
