package com.gupao.vip.homework.pattern.singleton.lazy.sync.doubleCheck;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazyDoubleSyncSingletonTest {
    private final static int LOOP_COUNT = 200;
    private final static CountDownLatch LATCH = new CountDownLatch( LOOP_COUNT );

    public static void main( String[] args ) {
        final ExecutorService threadPool = Executors.newFixedThreadPool( LOOP_COUNT );
        for ( int i = 0; i < LOOP_COUNT; i++ ) {
            threadPool.submit( () -> {
                try {
                    LATCH.await();
                    LazyDoubleSyncSingleton.getInstance();
                    System.out.println( LazyDoubleSyncSingleton.getInstance() );
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
            } );
            LATCH.countDown();
        }
        threadPool.shutdown();
    }
}
