package com.gupao.vip.homework.pattern.singleton.register;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RegisterSingletonTest {
    private static final int LOOP_COUNT = 200;
    private static final CountDownLatch LATCH = new CountDownLatch( LOOP_COUNT );

    public static void main( String[] args ) {
        ExecutorService es = Executors.newFixedThreadPool( LOOP_COUNT );
        for ( int i = 0; i < LOOP_COUNT; i++ ) {
            es.execute( () -> {
                try {
                    LATCH.await();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                System.out.println( RegisterSingleton.getInstance( "com.gupao.vip.homework.pattern.singleton.register.RegisterSingleton" ) );
            } );
            LATCH.countDown();
        }
        es.shutdown();
    }
}
