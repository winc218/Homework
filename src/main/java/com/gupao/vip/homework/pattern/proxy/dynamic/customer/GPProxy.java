package com.gupao.vip.homework.pattern.proxy.dynamic.customer;

import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GPProxy {
    private static String ln = "\n\r";

    public static Object newProxyInstance( GPClassLoader classLoader, Class< ? >[] interfaces, GPInvocationHandler h ) {
        // 1、动态生成源代码 .java文件
        String src = generateSrc( interfaces );
        // 2、输出到磁盘
        final Path path;
        try {
            path = Paths.get( GPProxy.class.getResource( "" ).toURI() );
            System.out.println( path );
            Files.write( path.resolve( "$Proxy0.java" ), src.getBytes() );

            // 3、把生成的.java文件编译成.class文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager( null, null, null );
            final Iterable< ? extends JavaFileObject > iterable = manager.getJavaFileObjects( path.resolve( "$Proxy0.java" ).toString() );
            final JavaCompiler.CompilationTask task = compiler.getTask( null, manager, null, null, null, iterable );
            task.call();
            manager.close();

            // 4、编译生成的.class文件加载到Jvm中
            final Class< ? > aClass = classLoader.findClass( "$Proxy0" );
            final Constructor< ? > constructor = aClass.getConstructor( GPInvocationHandler.class );
            // 5、返回字节码重组以后的新代理对象
            return constructor.newInstance( h );
        } catch ( IOException | URISyntaxException | ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e ) {
            e.printStackTrace();
        }
        return null;
    }

    private static String generateSrc( Class< ? >[] interfaces ) {
        StringBuilder sb = new StringBuilder();
        sb.append( "package com.example.javavip.proxy.dynamic.customer;" ).append( ln );
        sb.append( "import com.example.javavip.proxy.staticProxy.Person;" ).append( ln );
        sb.append( "import java.lang.reflect.Method;" ).append( ln );

        sb.append( "public class $Proxy0 implements " ).append( interfaces[ 0 ].getName() ).append( "{" ).append( ln );
            sb.append( "GPInvocationHandler h;" ).append( ln );
            sb.append( "public $Proxy0(GPInvocationHandler h) {" ).append( ln );
                sb.append( "this.h = h;" );
            sb.append( "}" ).append( ln );
        for ( Method m : interfaces[ 0 ].getMethods() ) {
            sb.append( "@Override" ).append( ln );
            sb.append( "public " ).append( m.getReturnType().getName() ).append( " " ).append( m.getName() ).append( "(){" ).append( ln );
                sb.append( "try{" ).append( ln );
                    sb.append( "Method m = " ).append( interfaces[ 0 ].getName() ).append( ".class.getMethod(\"" ).append( m.getName() ).append( "\", new Class[]{}); " ).append( ln );
                    sb.append( "this.h.invoke(this,m,null);" ).append( ln );
                sb.append( "} catch (Throwable e) {" ).append( ln );
                    sb.append( "e.printStackTrace();" );
                sb.append( "}" ).append( ln );
            sb.append( "}" ).append( ln );
        }
        sb.append( "}" ).append( ln );

        return sb.toString();
    }
}
