package com.gupao.vip.homework.pattern.proxy.dynamic.customer;

import java.lang.reflect.Method;

public interface GPInvocationHandler {
    Object invoke( Object proxy, Method method, Object[] args ) throws Throwable;
}
