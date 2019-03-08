package com.gupao.vip.homework.pattern.factory.simple;

public class SimpleFactoryTest {
    public static void main( String[] args ) {

        SimpleFactory factory = new SimpleFactory();

        System.out.println(factory.getMilk( "光明" ).getName());
    }
}
