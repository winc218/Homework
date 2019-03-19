package com.gupao.vip.homework.pattern.adapter;

public class AdapterTest {
    public static void main( String[] args ) {
        LoginFor3rdService loginFor3rdService = new LoginFor3rdService();
        System.out.println( loginFor3rdService.loginForQQ( "dafasdfa" ) );
    }
}
