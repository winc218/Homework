package com.gupao.vip.homework.pattern.decorator;

public class ILoginServiceImpl implements ILoginService {
    @Override
    public ResultMsg register( String username, String password ) {
        return new ResultMsg( "12132", "注册成功", "adsfasdf" );
    }

    @Override
    public ResultMsg login( String username, String password ) {
        return new ResultMsg( "12132", "登录成功", "adsfasdf" );
    }
}
