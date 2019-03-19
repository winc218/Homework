package com.gupao.vip.homework.pattern.observer.core;

import java.lang.reflect.Method;

public class Event {
    // 事件源
    private Object source;
    // 通知目标
    private Object target;
    // 回调
    private Method callback;
    // 触发事件
    private String trigger;

    public Event( Object target, Method callback ) {
        this.target = target;
        this.callback = callback;
    }

    public Object getSource() {
        return source;
    }

    Event setSource( Object source ) {
        this.source = source;
        return this;
    }

    public Object getTarget() {
        return target;
    }

    Event setTarget( Object target ) {
        this.target = target;
        return this;
    }

    public Method getCallback() {
        return callback;
    }

    Event setCallback( Method callback ) {
        this.callback = callback;
        return this;
    }

    public String getTrigger() {
        return trigger;
    }

    Event setTrigger( String trigger ) {
        this.trigger = trigger;
        return this;
    }

    @Override
    public String toString() {
        return "Event{" +
                "\nsource=" + source +
                ", \ntarget=" + target +
                ", \ncallback=" + callback +
                ", \ntrigger='" + trigger + '\'' +
                '}';
    }
}
