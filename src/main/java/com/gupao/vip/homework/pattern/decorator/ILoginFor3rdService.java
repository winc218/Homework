package com.gupao.vip.homework.pattern.decorator;

public interface ILoginFor3rdService extends ILoginService {

    ResultMsg loginForQQ( String id ) ;

    ResultMsg loginForWechat( String id );

    ResultMsg loginForToken( String token );
}
