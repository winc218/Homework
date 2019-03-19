package com.gupao.vip.homework.pattern.strategy.pay;


import com.gupao.vip.homework.pattern.strategy.PayState;

public class WechatPay implements Payment {

    @Override
    public PayState pay( int uid, double amount ) {
        System.out.println("欢迎使用微信支付");
        return new PayState(200, amount, "支付成功");
    }
}
