package com.gupao.vip.homework.pattern.factory.abs;


import com.gupao.vip.homework.pattern.factory.Milk;

public abstract class AbstractFactory {
    public abstract Milk getMengniu();
    public abstract Milk getGuangming();
    public abstract Milk getYili();
}
