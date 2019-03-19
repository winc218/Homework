package com.gupao.vip.homework.pattern.decorator;

/**
 * 为了某个实现类在不修改原始类的基础上进行动态地覆盖或者增加方法，采用装饰器模式
 * 该实现类保持跟原有类的层级关系
 * 装饰器模式实际上是一种非常特殊的适配器模式
 */
public class DecoratorTest {
    public static void main( String[] args ) {
        // 原来的功能依旧对外开放，依旧保留
        // 新功能同样也可以使用
        ILoginFor3rdService loginFor3rdService = new ILoginFor3rdServiceImpl( new ILoginServiceImpl() );
    }
}
