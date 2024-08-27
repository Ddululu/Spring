package com.example.demo.dao;

import com.example.demo.vo.Board;
import com.example.demo.vo.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class BoardDAO {
    @Autowired
    private JdbcTemplate temp;

    public class BoardResultMap implements RowMapper<Board> {
        @Override
        public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Board(rs.getInt(1), rs.getString(2),rs.getDate(3),
                    rs.getString(4),rs.getString(5));
        }
    }

    public void insert(Board board) {
        String sql = "insert into board(writer,wdate,title,content) values(?,sysdate(),?,?)";
        temp.update(sql,board.getWriter(),board.getTitle(),board.getContent());
    }
    public List<Board> selectAll() {
        String sql = "select * from board";
        return temp.query(sql, new BoardResultMap());
    }
    public Board selectById(int index) {
        String sql= "select * from board where num  = ?";
        return temp.queryForObject(sql,new BoardResultMap(),index);
    }
    public List<Board> selectByWriter(String name) {
        String sql = "select* from board where writer =? order by num";
        return temp.query(sql,new BoardResultMap(),name);
    }
    public List<Board> selectByTitle(String title){
        String sql = "select * from board where title like ? order by num";
        return temp.query(sql,new BoardResultMap(),title);
    }
    public void delete(int index) {
        String sql = "delete from board where num  = ?";
        temp.update(sql,index);
    }
    public void update(Board board) {
        String sql = "update board set writer = ?, title = ? , content= ? where num =? ";
        temp.update(sql,board.getWriter(),board.getTitle(),board.getContent(),board.getIndex());
    }
}
