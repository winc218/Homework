package com.gupao.vip.homework.pattern.strategy;


import com.gupao.vip.homework.pattern.strategy.pay.Order;
import com.gupao.vip.homework.pattern.strategy.pay.PayType;

public class PayTest {
    public static void main( String[] args ) {
        Order order= new Order( 201801,"撒反对", 200000 );
        System.out.println( order.pay( PayType.ALI_PAY ) );
    }
}
