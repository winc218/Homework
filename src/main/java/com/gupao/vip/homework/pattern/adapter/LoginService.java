package com.gupao.vip.homework.pattern.adapter;

public class LoginService {
    public ResultMsg regists(String username, String password) {
        return new ResultMsg( "12132","注册成功", "adsfasdf" );
    }

    public ResultMsg login(String username, String password) {
        return new ResultMsg( "12132","登录成功", "adsfasdf" );
    }
}
