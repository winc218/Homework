package com.gupao.vip.homework.pattern.delegate.SimpleDemo;

public class MemberA implements IMember{
    @Override
    public void doThing() {
        System.out.println("我是员工A,我负责加密");
    }
}
