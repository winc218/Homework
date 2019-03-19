package com.gupao.vip.homework.pattern.template;

import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemberDao  {

    private JDBCTemplate jdbcTemplate = new JDBCTemplate(null);

    public List<?> query() {
        String sql = "select * from t_member";
        return jdbcTemplate.execute( sql, ( RowMapper< Map > ) ( rs, rowNum ) -> {
            try {
                final int columnCount = rs.getMetaData().getColumnCount();
                final ResultSetMetaData metaData = rs.getMetaData();
                Map< String, String > columnMap = new HashMap<>( columnCount );
                for ( int i = 0; i < columnCount; i++ ) {
                    columnMap.put( metaData.getColumnName( i ), rs.getString( i ) );
                }
                return columnMap;
            } catch ( SQLException e ) {
                e.printStackTrace();
            }
            return null;
        }, null );
    }
}
