package com.gupao.vip.homework.pattern.strategy;

import com.example.javavip.strategy_demo.pay.Order;
import com.example.javavip.strategy_demo.pay.PayType;

public class PayTest {
    public static void main( String[] args ) {
        Order order= new Order( 201801,"撒反对", 200000 );
        System.out.println( order.pay( PayType.ALI_PAY ) );
    }
}
