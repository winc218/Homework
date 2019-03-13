package com.gupao.vip.homework.pattern.singleton.hungry;

public class HungrySingleton {
    private final static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
