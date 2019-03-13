package com.gupao.vip.homework.pattern.singleton.lazy.inner_class;


public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return InstanceHandler.instance;
    }

    private static class InstanceHandler {
        private static StaticInnerClassSingleton instance = new StaticInnerClassSingleton();
    }
}
