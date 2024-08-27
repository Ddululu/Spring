package com.example.demo.scope;

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

    public class ScopeResultMap implements RowMapper<Member> {
        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Member(rs.getString(1), rs.getString(2),rs.getString(3),
                    rs.getString(4),rs.getString(5));
        }
    }

    public void insert(Member m){
        String sql="insert into member values(?,?,?,?,?)";
        temp.update(sql,m.getId(),m.getPwd(),m.getName(),m.getEmail(),m.getType());
    };
    public Member select(String id) throws SQLException{
        String sql="select * from member where id=?";
        Member account = null;
            account = temp.queryForObject(sql, new ScopeResultMap(), id);
        return account;
    };
    public void update(Member m){
        String sql="update member set name=?,email=?,type=? where id=?";
        temp.update(sql,m.getName(),m.getEmail(),m.getType(),m.getId());
    };
    public void delete(Member m){
        String sql="delete from member where id=?";
        temp.update(sql,m.getId());
    };
}
