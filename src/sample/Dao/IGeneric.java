package sample.Dao;


import sample.Mapper.RowMapper;

import java.util.List;

public interface IGeneric<T> {
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);
    void update (String sql, Object... parameters);
    Long insert (String sql, Object... parameters);
    int count(String sql, Object... parameters);
}
