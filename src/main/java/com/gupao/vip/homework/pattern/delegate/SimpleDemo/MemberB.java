package com.gupao.vip.homework.pattern.delegate.SimpleDemo;

public class MemberB implements IMember {
    @Override
    public void doThing() {
        System.out.println( "我的员工B，我负责登录" );
    }
}
