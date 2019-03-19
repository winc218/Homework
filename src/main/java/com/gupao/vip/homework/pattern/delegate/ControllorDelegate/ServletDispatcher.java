package com.gupao.vip.homework.pattern.delegate.ControllorDelegate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ServletDispatcher {
    private Map< String, Handler > handlerMapping;

    public ServletDispatcher() {
        handlerMapping = new ConcurrentHashMap<>( 2 );
        try {
            handlerMapping.put( "/test.do",
                    new Handler().setControler( MemberAction.class.newInstance() )
                            .setMethod( MemberAction.class.getMethod( "getMemberName", String.class ) ) ).setUri( "/test.do" );
        } catch ( InstantiationException | IllegalAccessException | NoSuchMethodException e ) {
            e.printStackTrace();
        }
    }

    public void doService( HttpServletRequest req, HttpServletResponse res ) {
        doDispatch( req, res );
    }

    public void doDispatch( HttpServletRequest req, HttpServletResponse res ) {
        // 1、获取用户请求的URL
        //    按照J2EE标准，每个URL对应一个Servlet，URL由浏览器输入
        final String requestURI = req.getRequestURI();

        // 2、Servlet那到URL后，要做权衡（做判断、做选择）
        //    跟据用户请求的URL，去找到对应的某个java类的方法
        // 3、通过拿到的URL去handlerMapping（认为是策略常量）
        // 4、将具体的通过反射去调用其对应的方法
        // 5、获取到Method执行的结果，通过Response返回到页面上
        if ( handlerMapping.containsKey( requestURI ) ) {
            final Handler handler = handlerMapping.get( requestURI );
            try {
                final Object mic = handler.getMethod().invoke( handler.getControler(), req.getParameter( "mic" ) );
                System.out.println( mic );
            } catch ( IllegalAccessException | InvocationTargetException e ) {
                e.printStackTrace();
            }
        }
    }
}

class Handler {
    private Object controler;
    private String uri;
    private Method method;

    public Object getControler() {
        return controler;
    }

    public Handler setControler( Object controler ) {
        this.controler = controler;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public Handler setUri( String uri ) {
        this.uri = uri;
        return this;
    }

    public Method getMethod() {
        return method;
    }

    public Handler setMethod( Method method ) {
        this.method = method;
        return this;
    }
}