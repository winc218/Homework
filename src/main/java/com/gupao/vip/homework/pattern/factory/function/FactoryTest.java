package com.gupao.vip.homework.pattern.factory.function;

public class FactoryTest {
    public static void main( String[] args ) {
        Factory factory = new MengniuFactory();
        System.out.println( factory.getMilk().getName() );
    }
}
