package com.gupao.vip.homework.pattern.singleton.lazy.sync;

public class LazySyncSingleton {
    private static LazySyncSingleton instance;
    private LazySyncSingleton() {}

    public static LazySyncSingleton getInstance() {
        synchronized ( LazySyncSingleton.class ) {
            if(null == instance) {
                instance = new LazySyncSingleton();
            }
        }
        return instance;
    }
}
