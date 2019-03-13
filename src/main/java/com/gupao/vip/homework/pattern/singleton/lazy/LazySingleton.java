package com.gupao.vip.homework.pattern.singleton.lazy;

public class LazySingleton {
    private static LazySingleton instance = null;

    /**
     * 防止反射实例化新对象
     */
    private LazySingleton()
    {
        if( null != instance)
        {
            throw new RuntimeException("instance can not creat any more ,is already exists");
        }
    }

    public static LazySingleton getInstance() {
        if ( instance == null ) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
