package com.gupao.vip.homework.pattern.proxy.dynamic.customer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Paths;

public class GPClassLoader extends ClassLoader {
    private File classPathFile;

    public GPClassLoader() {
        try {
            final URI uri = GPClassLoader.class.getResource( "" ).toURI();
            this.classPathFile = Paths.get( uri ).toFile();
        } catch ( URISyntaxException e ) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class< ? > findClass( String name ) throws ClassNotFoundException {
        String className = GPClassLoader.class.getPackage().getName() + "." + name;
        if ( classPathFile != null ) {
            final File classFile = new File( classPathFile, name.replaceAll( "\\.", "/" ) + ".class" );
            if ( classFile.exists() ) {
                try ( FileInputStream in = new FileInputStream( classFile ); ByteArrayOutputStream out = new ByteArrayOutputStream() ) {
                    byte[] buff = new byte[ 1024 ];
                    int len;
                    while ( ( len = in.read( buff ) ) != -1 ) {
                        out.write( buff, 0, len );
                    }
                    return defineClass( className, out.toByteArray(), 0, out.size() );
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
