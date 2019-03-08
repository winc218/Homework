package com.gupao.vip.homework.pattern.factory.simple;


import com.gupao.vip.homework.pattern.factory.Mengniu;
import com.gupao.vip.homework.pattern.factory.Milk;
import com.gupao.vip.homework.pattern.factory.Guangming;
import com.gupao.vip.homework.pattern.factory.Yili;

public class SimpleFactory {
    public Milk getMilk( String name ) {

        switch ( name ) {
            case "伊利":
                return new Yili();
            case "蒙牛":
                return new Mengniu();
            case "光明":
                return new Guangming();
            default:
                System.out.println( "不能生产指定牛奶" );
                return null;
        }
    }
}
