package com.gupao.vip.homework.pattern.decorator;

public class ILoginFor3rdServiceImpl implements ILoginFor3rdService {
    private final ILoginService loginService;

    public ILoginFor3rdServiceImpl( ILoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public ResultMsg register( String username, String password ) {
        return loginService.register( username, password );
    }

    @Override
    public ResultMsg login( String username, String password ) {
        return loginService.login( username, password );
    }


    @Override
    public ResultMsg loginForQQ( String id) {
        // 1、id为唯一值，当作username
        // 2、password为空

        // 3、调用原来的代码完成注册和登录
        ResultMsg regists = this.register( id, null );
        System.out.println( regists );
        ResultMsg login = this.login( id, null );
        return login;
    }

    @Override
    public ResultMsg loginForWechat( String id) {
        return null;
    }

    @Override
    public ResultMsg loginForToken( String token) {
        return null;
    }
}
