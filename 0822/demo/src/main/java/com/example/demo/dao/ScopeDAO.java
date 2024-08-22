package com.example.demo.dao;

import com.example.demo.vo.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class ScopeDAO {
    @Autowired
    private JdbcTemplate temp;

    public class ScopeResultMap implements RowMapper<Scope> {
        @Override
        public Scope mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Scope(rs.getString(1), rs.getString(2),rs.getString(3),
                    rs.getString(4),rs.getString(5));
        }
    }

    public void insert(Scope m){
        String sql="insert into member values(?,?,?,?,?)";
        temp.update(sql,m.getId(),m.getPwd(),m.getName(),m.getEmail(),m.getType());
    };
    public Scope select(String id) throws SQLException{
        String sql="select * from member where id=?";
        Scope account = null;
            account = temp.queryForObject(sql, new ScopeResultMap(), id);
        return account;
    };
    public void update(Scope m){
        String sql="update member set name=?,email=?,type=? where id=?";
        temp.update(sql,m.getName(),m.getEmail(),m.getType(),m.getId());
    };
    public void delete(Scope m){
        String sql="delete from member where id=?";
        temp.update(sql,m.getId());
    };
}
