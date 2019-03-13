package com.gupao.vip.homework.pattern.proxy.dynamic.jdk;

import com.example.javavip.proxy_demo.staticProxy.Person;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKMeipo implements InvocationHandler {
    private Person target;

    public Object getInstance( Person target ) {
        this.target = target;

        Class clazz = target.getClass();

        return Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this );
    }

    @Override
    public Object invoke( Object proxy, Method method, Object[] args ) throws Throwable {
        System.out.println("我是媒婆，我要给你找对象");
        System.out.println("开始物色");
        method.invoke( this.target, args );
        System.out.println("找到对象");
        return null;
    }
}
