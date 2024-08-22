package com.example.demo.dao;

import com.example.demo.vo.GuestBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Repository
public class GB_DAO {
    @Autowired
    private JdbcTemplate temp; // DB 작업을 간단하게 처리할 수 있는 도구

    //resultMap 정의
    public class GuestResultMap implements RowMapper<GuestBook> {
        // RowMapper의 메소드로 상속받아 각 컬럼의 결과를 vo 생성자에 맵핑. => 객체가 만들어짐
        @Override
        public GuestBook mapRow(ResultSet rs, int rowNum) throws SQLException {
            // ResultSet의 한 행을 처리. param으로 처리할 행 번호를 받음.
            return new GuestBook(rs.getInt(1), rs.getString(2),
                    rs.getString(3), rs.getDate(4), rs.getString(5));
        }
    }
        // 주입 받은 vo 객체를 이용해 sql 구문을 완성하고 JdbcTemplate.update() 메소드 호출
    public void insert(GuestBook vo) {
        String sql = "insert into guestbook(writer,pwd,wdate,content) values(?,?,sysdate(),?)";
        temp.update(sql, new Object[] {vo.getWriter(),vo.getPwd(),vo.getContent()});
    }

    // index 값을 입력해 처음 조회된 레코든 1행을 가져와 vo에 값을 주입.
    // queryForObject(query, 결과를 저장할 객체,?에 넣을 변수 ) 한줄 검색
    public GuestBook select(int index) {
        String sql = "select * from guestbook where num=?";
        GuestBook vo = null;
        try {
            vo = temp.queryForObject(sql, new GuestResultMap(), index);
        }catch(Exception e) {
            e.printStackTrace();
        }

        return vo;
    }

    public ArrayList<GuestBook> selectAll() {
        String sql = "select * from guestbook order by num";
        return (ArrayList<GuestBook>) temp.query(sql, new GuestResultMap(){});
    }

    public void update(GuestBook vo) {
        String sql = "update guestbook set content=? where num=?";
        temp.update(sql, new Object[]{vo.getContent(), vo.getIndex()});
    }

    public void delete(int index) {
        String sql = "delete from guestbook where num=?";
        temp.update(sql, index);
    }
}

