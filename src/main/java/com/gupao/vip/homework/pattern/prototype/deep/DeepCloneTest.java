package com.gupao.vip.homework.pattern.prototype.deep;


import com.gupao.vip.homework.pattern.prototype.ChildBean;

public class DeepCloneTest {
    public static void main( String[] args ) {
        DeepBean source = new DeepBean();
        ChildBean childBean = new ChildBean();
        source.setChildBean( childBean );

        DeepBean target = source.deepClone();
        System.out.println( "source:" + source.hashCode() );
        System.out.println( "target:" + target.hashCode() );
        System.out.println( "sourceChild:" + source.getChildBean().hashCode() );
        System.out.println( "targetChild:" + target.getChildBean().hashCode() );
    }
}
