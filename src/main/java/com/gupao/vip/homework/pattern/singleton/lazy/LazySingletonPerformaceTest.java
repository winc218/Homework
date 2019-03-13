package com.gupao.vip.homework.pattern.singleton.lazy;

public class LazySingletonPerformaceTest {
    private static final int LOOP_COUNT = 20000000;

    public static void main( String[] args ) {
        long start = System.currentTimeMillis();
        for ( int i = 0; i < LOOP_COUNT; i++ ) {
            LazySingleton.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start );
    }
}
