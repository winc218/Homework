package com.gupao.vip.homework.pattern.template;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 原始的模板模式是使用抽象类来实现的
 * Spring采用注入和接口的形式来完成方法的解耦
 */
public class JDBCTemplate {
    private DataSource dataSource;

    public JDBCTemplate( DataSource dataSource ) {
        this.dataSource = dataSource;
    }

    private Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private PreparedStatement getStatement( Connection connection, String sql ) throws SQLException {
        return connection.prepareStatement( sql );
    }

    private ResultSet executeQuery( PreparedStatement pst, Object[] values ) throws SQLException {
        for ( int i = 0; i < values.length; i++ ) {
            pst.setObject( i, values[ i ] );
        }
        return pst.executeQuery();
    }

    final List< ? > execute( String sql, RowMapper< ? > rowMapper, Object[] values ) {
        // 1、获取连接
        try ( Connection conn = this.getConnection();
              // 2、获取语句集
              PreparedStatement pst = this.getStatement( conn, sql );
              // 3、执行语句集，并获得结果集
              ResultSet rs = this.executeQuery( pst, values ) ) {
            // 4、解析语句集
            return this.parseResultSet( rs, rowMapper );
        } catch ( SQLException e ) {
            e.printStackTrace();
        }
        return null;
    }

    private List< ? > parseResultSet( ResultSet rs, RowMapper rowMapper ) throws SQLException {
        final int fetchSize = rs.getFetchSize();
        List< Object > resultList = new ArrayList<>( fetchSize );
        int rowNum = 1;
        while ( rs.next() ) {
            resultList.add( rowMapper.mapRow( rs, rowNum++ ) );
        }
        return resultList;
    }
}
