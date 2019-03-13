package com.gupao.vip.homework.pattern.singleton.hungry;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HungrySingletonTest {
    private static int loopCount = 20000;

    public static CountDownLatch latch = new CountDownLatch( loopCount );

    public static void main( String[] args ) {
        ExecutorService es = Executors.newFixedThreadPool( loopCount );
        long start = System.currentTimeMillis();
        for ( int i = 0; i < loopCount; i++ ) {
            es.execute( () -> {
                try {
                    latch.await();
                } catch ( InterruptedException e ) {
                    e.printStackTrace();
                }
                HungrySingleton.getInstance();
//                System.out.println( HungrySingleton.getInstance() );
            } );
            latch.countDown();
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start );
        es.shutdown();
    }
}
