package com.gupao.vip.homework.pattern.strategy.pay;

public enum PayType {
    // 阿里支付
    ALI_PAY(new AliPay()),
    // 微信支付
    WEBCHAT_PAY(new WechatPay());
    private Payment payment;

    PayType(Payment payment) {
        this.payment = payment;
    }

    public Payment get(){
        return this.payment;
    }
}
