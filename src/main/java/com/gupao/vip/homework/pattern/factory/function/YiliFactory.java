package com.gupao.vip.homework.pattern.factory.function;


import com.gupao.vip.homework.pattern.factory.Milk;
import com.gupao.vip.homework.pattern.factory.Yili;

public class YiliFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Yili();
    }
}
