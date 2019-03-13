package com.gupao.vip.homework.pattern.singleton.lazy.sync;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazySyncSingletonTest {
    private final static int LOOP_COUNT = 200;
    private final static CountDownLatch LATCH = new CountDownLatch( LOOP_COUNT );

    public static void main( String[] args ) {
        final ExecutorService threadPool = Executors.newFixedThreadPool( LOOP_COUNT );
        long start = System.currentTimeMillis();
        for ( int i = 0; i < LOOP_COUNT; i++ ) {
            threadPool.submit( () -> {
                try {
                    LATCH.await();
                    LazySyncSingleton.getInstance();
                    System.out.println( LazySyncSingleton.getInstance() );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            } );
            LATCH.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start );
        threadPool.shutdown();
    }
}
