package com.gupao.vip.homework.pattern.template;

import java.sql.ResultSet;

public interface RowMapper<T> {
    T mapRow( ResultSet rs, int rowNum );
}
