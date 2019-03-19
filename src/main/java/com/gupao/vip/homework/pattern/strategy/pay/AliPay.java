package com.gupao.vip.homework.pattern.strategy.pay;


import com.gupao.vip.homework.pattern.strategy.PayState;

public class AliPay implements Payment {

    @Override
    public PayState pay( int uid, double amount ) {
        System.out.println("欢迎使用支付宝");
        return new PayState( 200,  amount, "支付成功" );
    }
}
