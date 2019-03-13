package com.gupao.vip.homework.pattern.proxy.dynamic.jdk;


import com.gupao.vip.homework.pattern.proxy.staticProxy.Person;

public class Xiemu implements Person {
    @Override
    public void findlove() {
        System.out.println("肤白貌美大长腿");
        System.out.println("身高165cm");
    }

    @Override
    public void findJob() {

    }
}
