package com.gupao.vip.homework.pattern.proxy.staticProxy;

public class Son implements Person{

    @Override
    public void findlove() {
        System.out.println("找对象，肤白貌美大长腿");
    }

    @Override
    public void findJob() {
        System.out.println("年薪50K");
    }
}
