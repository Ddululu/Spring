package com.example.demo.conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//db 연결. db서버에 로그인해서 세션 수립
@Component
public class MysqlConnect {
    @Autowired
    private static MysqlConnect myconn;

    @Value("${spring.datasource.url}")
    private String url;

    @Value("${spring.datasource.driver-class-name}")
    private String driver;

    @Value("${spring.datasource.username}")
    private String username;

    @Value("${spring.datasource.password}")
    private String password;

    //싱글톤. 자원관리
    private MysqlConnect() {

    }

    public static MysqlConnect getInstance() {
        return myconn;
    }

    //db연결하여 커넥션 객체 반환
    public Connection getConn() {
        try {
            System.out.print("url:"+url+ username+password+ driver);
            //드라이버 로드
            Class.forName(driver); //여기서 에러나면 드라이버 빌드패스 확인
            //로그인. 세션 수립
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }
}