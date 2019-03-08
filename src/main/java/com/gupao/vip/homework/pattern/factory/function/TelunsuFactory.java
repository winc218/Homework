package com.gupao.vip.homework.pattern.factory.function;


import com.gupao.vip.homework.pattern.factory.Milk;
import com.gupao.vip.homework.pattern.factory.Guangming;

public class GuangmingFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Guangming();
    }
}
