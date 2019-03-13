package com.gupao.vip.homework.pattern.proxy.dynamic.jdk;

import com.example.javavip.proxy_demo.staticProxy.Person;

public class JDKProxyText {
    public static void main( String[] args ) {
        final Person instance = ( Person ) new JDKMeipo().getInstance( new Xiemu() );
//        System.out.println( instance );
        instance.findlove();

//        final byte[] $Proxy0s = ProxyGenerator.generateProxyClass( "$Proxy0", new Class[] { Person.class } );
//        try ( FileOutputStream os = new FileOutputStream( "D://$Proxy0.class" ) ) {
//            os.write( $Proxy0s );
//        } catch ( IOException e ) {
//            e.printStackTrace();
//        }

    }
}
