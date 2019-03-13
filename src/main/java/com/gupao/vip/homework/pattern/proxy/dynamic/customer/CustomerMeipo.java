package com.gupao.vip.homework.pattern.proxy.dynamic.customer;

import com.example.javavip.proxy_demo.staticProxy.Person;

import java.lang.reflect.Method;

public class CustomerMeipo implements GPInvocationHandler {
    private Person target;

    public Object getInstance( Person target ) {
        this.target = target;

        Class clazz = target.getClass();

        return GPProxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this );
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
