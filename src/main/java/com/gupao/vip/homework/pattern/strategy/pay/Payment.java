package com.gupao.vip.homework.pattern.strategy.pay;


import com.gupao.vip.homework.pattern.strategy.PayState;

public interface Payment {
    PayState pay( int uid, double amount );
}
