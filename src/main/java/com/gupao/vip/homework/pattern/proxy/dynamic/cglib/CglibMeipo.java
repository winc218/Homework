package com.gupao.vip.homework.pattern.proxy.dynamic.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibMeipo implements MethodInterceptor {
    public < T > T getInstance( Class< ? > clazz ) {
//        Enhancer enhancer = new Enhancer();

        // 要把哪个类设置为即将生成的新的类的父类
//        enhancer.setSuperclass( clazz );
//        enhancer.setCallback( this );

        return ( T ) Enhancer.create(clazz, this);
    }

    @Override
    public Object intercept( Object o, Method method, Object[] objects, MethodProxy methodProxy ) throws Throwable {
        // 具体业务的增强
        System.out.println( "我是媒婆，我要给你找对象" );
        methodProxy.invokeSuper( o, objects );
//        methodProxy.invoke( o, objects );
        System.out.println( "找到对象" );
        return null;
    }
}
