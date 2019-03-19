package com.gupao.vip.homework.pattern.delegate.SimpleDemo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Leader {
    Map< String, IMember > map = new ConcurrentHashMap<>();

    public Leader() {
        map.put( "加密", new MemberA() );
        map.put( "登录", new MemberB() );
    }


    public void doThing( String work ) {
        map.get( work ).doThing();
    }
}
