package com.gupao.vip.homework.pattern.observer.guava;

import com.google.common.eventbus.Subscribe;

public class Teacher {
    private String name;

    public Teacher( String name ) {
        this.name = name;
    }

    @Subscribe
    public void notification( Question question ) {
        System.out.println( name + "老师，学员:[" + question.getName() + "]发布了一个问题，问题内容是：[" + question.getContent() + "]" );
    }
}
