package com.gupao.vip.homework.pattern.observer.guava;

import com.google.common.eventbus.EventBus;

public class GuavaTest {
    public static void main( String[] args ) {
        Question question = new Question("邓嘉龙","如何学好高级Java架构师的课程？");
        Teacher teacher = new Teacher( "Tom" );

        EventBus eventBus = new EventBus(  );
        eventBus.register( teacher );
        eventBus.post( question );
    }

}
