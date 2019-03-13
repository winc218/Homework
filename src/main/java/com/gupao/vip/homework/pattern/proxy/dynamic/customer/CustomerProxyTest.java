package com.gupao.vip.homework.pattern.proxy.dynamic.customer;


import com.gupao.vip.homework.pattern.proxy.dynamic.jdk.Xiemu;
import com.gupao.vip.homework.pattern.proxy.staticProxy.Person;

public class CustomerProxyTest{
    public static void main( String[] args ) {
        final Person instance = ( Person ) new CustomerMeipo().getInstance( new Xiemu() );
        instance.findlove();
    }
}
