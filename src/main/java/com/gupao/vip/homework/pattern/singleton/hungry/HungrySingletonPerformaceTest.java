package com.gupao.vip.homework.pattern.singleton.hungry;

public class HungrySingletonPerformaceTest {
    private static int loopCount = 20000000;


    public static void main( String[] args ) {
        long start = System.currentTimeMillis();
        for ( int i = 0; i < loopCount; i++ ) {
            HungrySingleton.getInstance();
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start );
    }
}
