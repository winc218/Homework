package com.gupao.vip.homework.pattern.singleton.register;

public class RegisterSingletonPerformaceTest {
    private static final long LOOP_COUNT = 20000000;

    public static void main( String[] args ) {
        long start = System.currentTimeMillis();
        for ( int i = 0; i < LOOP_COUNT; i++ ) {
            RegisterSingleton.getInstance( "com.gupao.vip.homework.pattern.singleton.register.RegisterSingleton" );
        }
        long end = System.currentTimeMillis();
        System.out.println( end - start );
    }
}
