package com.gupao.vip.homework.pattern.singleton.register;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class RegisterSingleton {
    /**
     * 用ConcurrentHashMap来维护映射关系，这是线程安全的
     */
    private static final Map< String, Object > registerMap = new ConcurrentHashMap<>();

    static {
        //把RegistSingleton自己也纳入容器管理
        RegisterSingleton registerSingleton = new RegisterSingleton();
        registerMap.put( registerSingleton.getClass().getName(), registerSingleton );
    }

    private RegisterSingleton() {
    }

    public static Object getInstance( String className ) {
        //如果传入的类名为空，就返回RegistSingleton实例
        if ( null == className ) {
            className = RegisterSingleton.class.getName();
        }
        //如果没有登记就用反射new一个
        synchronized ( registerMap ) {
            if ( !registerMap.containsKey( className ) ) {
                try {
                    registerMap.put( className, Class.forName( className ).newInstance() );
                } catch ( InstantiationException | IllegalAccessException | ClassNotFoundException e ) {
                    e.printStackTrace();
                }
            }
        }
        return registerMap.get( className );
    }
}
