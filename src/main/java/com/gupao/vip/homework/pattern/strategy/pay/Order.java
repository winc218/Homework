package com.gupao.vip.homework.pattern.strategy.pay;


import com.gupao.vip.homework.pattern.strategy.PayState;

public class Order {
    private int uid;
    private String orderId;
    private double amount;

    public Order( int uid, String orderId, double amount ) {
        this.uid = uid;
        this.orderId = orderId;
        this.amount = amount;
    }

    public PayState pay( PayType payType) {
        return payType.get().pay(this.uid, this.amount);
    }
}
