package com.gupao.vip.homework.pattern.singleton.lazy.inner_class;

import com.gupao.vip.homework.pattern.singleton.lazy.LazySingleton;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StaticInnerClassSingletonTest {
    private static final int LOOP_COUNT = 200;
    private static final CountDownLatch LATCH = new CountDownLatch( LOOP_COUNT );

    public static void main( String[] args ) {
        ExecutorService es = Executors.newFixedThreadPool( LOOP_COUNT );
        long start = System.currentTimeMillis();
        for ( int i = 0; i < LOOP_COUNT; i++ ) {
            es.execute( () -> {
                try {
                    LATCH.await();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                System.out.println( StaticInnerClassSingleton.getInstance() );
            } );
            LATCH.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start );
        es.shutdown();
    }
}
