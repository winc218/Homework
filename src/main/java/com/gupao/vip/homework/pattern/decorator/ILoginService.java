package com.gupao.vip.homework.pattern.decorator;

/**
 * @author Deng Jialong
 */
public interface ILoginService {
    ResultMsg register( String username, String password );
    ResultMsg login( String username, String password );
}
