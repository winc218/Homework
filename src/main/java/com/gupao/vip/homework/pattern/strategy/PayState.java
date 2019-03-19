package com.gupao.vip.homework.pattern.strategy;

public class PayState {
    private int code;
    private Object data;
    private String msg;

    public PayState( int code, Object data, String msg ) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "支付状态" + code + " , " + msg + ", 交易详情：" + data;
    }
}
