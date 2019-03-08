package com.gupao.vip.homework.pattern.factory.function;


import com.gupao.vip.homework.pattern.factory.Mengniu;
import com.gupao.vip.homework.pattern.factory.Milk;

public class MengniuFactory implements Factory {
    @Override
    public Milk getMilk() {
        return new Mengniu();
    }
}
