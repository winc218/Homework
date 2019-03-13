package com.gupao.vip.homework.pattern.singleton.lazy.sync.doubleCheck;

public class LazyDoubleSyncSingleton {
    private static LazyDoubleSyncSingleton instance;

    private LazyDoubleSyncSingleton() {
    }

    public static LazyDoubleSyncSingleton getInstance() {
        if ( null == instance ) {
            synchronized ( LazyDoubleSyncSingleton.class ) {
                if ( null == instance ) {
                    instance = new LazyDoubleSyncSingleton();
                }
            }
        }
        return instance;
    }
}
