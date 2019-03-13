package com.gupao.vip.homework.pattern.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;

public class CglibTest {
    public static void main( String[] args ) {
        final ZhangSan instance = (ZhangSan ) Enhancer.create(ZhangSan.class, new CglibMeipo());
//        final ZhangSan instance = new CglibMeipo().getInstance( ZhangSan.class );
        instance.findlove();
    }
}
