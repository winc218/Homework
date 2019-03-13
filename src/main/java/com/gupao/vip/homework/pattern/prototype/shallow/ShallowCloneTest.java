package com.gupao.vip.homework.pattern.prototype.shallow;


import com.gupao.vip.homework.pattern.prototype.ChildBean;

public class ShallowCloneTest {
    public static void main( String[] args ) throws CloneNotSupportedException {
        ShallowBean source = new ShallowBean();
        ChildBean childBean = new ChildBean();
        source.setChildBean( childBean );

        ShallowBean target = source.clone();
        System.out.println( "source:" + source.hashCode() );
        System.out.println( "target:" + target.hashCode() );
        System.out.println( "sourceChild:" + source.getChildBean().hashCode() );
        System.out.println( "targetChild:" + target.getChildBean().hashCode() );
    }
}
