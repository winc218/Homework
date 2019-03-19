package com.gupao.vip.homework.pattern.adapter;

public class LoginFor3rdService extends LoginService {
    public ResultMsg loginForQQ(String id) {
        // 1、id为唯一值，当作username
        // 2、password为空

        // 3、调用原来的代码完成注册和登录
        ResultMsg regists = super.regists( id, null );
        System.out.println( regists );
        ResultMsg login = super.login( id, null );
        return login;
    }

    public ResultMsg loginForWechat(String id) {
        return null;
    }

    public ResultMsg loginForToken(String token) {
        return null;
    }
}
