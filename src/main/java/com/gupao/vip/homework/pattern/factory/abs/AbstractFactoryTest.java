package com.gupao.vip.homework.pattern.factory.abs;

public class AbstractFactoryTest {
    public static void main( String[] args ) {
        AbstractFactory factory = new MilkFactory();
        System.out.println( factory.getMengniu().getName() );
    }
}
