package com.gupao.vip.homework.pattern.factory.abs;


import com.gupao.vip.homework.pattern.factory.Mengniu;
import com.gupao.vip.homework.pattern.factory.Milk;
import com.gupao.vip.homework.pattern.factory.Guangming;
import com.gupao.vip.homework.pattern.factory.Yili;

public class MilkFactory extends AbstractFactory {
    @Override
    public Milk getMengniu() {
        return new Mengniu();
    }

    @Override
    public Milk getGuangming() {
        return new Guangming();
    }

    @Override
    public Milk getYili() {
        return new Yili();
    }
}
