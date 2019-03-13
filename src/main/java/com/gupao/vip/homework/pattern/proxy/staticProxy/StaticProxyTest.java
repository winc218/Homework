package com.gupao.vip.homework.pattern.proxy.staticProxy;

public class StaticProxyTest {
    public static void main( String[] args ) {
        Son son = new Son(  );
        Father father = new Father( son );
        father.findLove();
    }
}