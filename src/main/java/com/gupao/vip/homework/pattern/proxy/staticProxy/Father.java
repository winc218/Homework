package com.gupao.vip.homework.pattern.proxy.staticProxy;

public class Father {

    private Son son;

    public Father( Son son ) {
        this.son = son;
    }

    public void findLove() {
        System.out.println( "我是父亲，我要给你找女朋友" );
        son.findlove();
        System.out.println("双方父母同意");
    }
}