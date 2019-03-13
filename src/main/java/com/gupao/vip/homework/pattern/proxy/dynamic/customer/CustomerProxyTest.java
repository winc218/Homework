package com.gupao.vip.homework.pattern.proxy.dynamic.customer;

import com.example.javavip.proxy_demo.dynamic.jdk.Xiemu;
import com.example.javavip.proxy_demo.staticProxy.Person;

public class CustomerProxyTest{
    public static void main( String[] args ) {
        final Person instance = ( Person ) new CustomerMeipo().getInstance( new Xiemu() );
        instance.findlove();
    }
}
