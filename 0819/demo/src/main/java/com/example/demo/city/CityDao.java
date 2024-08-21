package com.example.demo.city;

import com.example.demo.conn.MysqlConnect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;

@Repository
public class CityDao {
    @Autowired
    private MysqlConnect dbconn;

    public CityDao(){
        dbconn = MysqlConnect.getInstance();
    }

    public CityVO select(int id){
        Connection conn = dbconn.getConn();
        String sql = "select * from city where id =?";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                return new CityVO(rs.getInt(1),rs.getString(2),
                        rs.getString(3),rs.getString(4),rs.getInt(5));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        System.out.println("널");
        return null;
    }

    public int insert(CityVO city){
        Connection conn = dbconn.getConn();
        String sql = "insert into city(name,countrycode,district,population) values(?,?,?,?)";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,city.getName());
            pstmt.setString(2, city.getCountryCode());
            pstmt.setString(3, city.getDistrict());
            pstmt.setInt(4, city.getPopulation());
            pstmt.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            try{
                conn.close();
            }catch(SQLException e){
                e.printStackTrace();
            }

        }
        return 0;
    }

    public ArrayList<CityVO> selectAll(){
        ResultSet rs = null;
        ArrayList<CityVO> list = new ArrayList<CityVO>();
        Connection conn = dbconn.getConn();
        String sql = "select * from city order by id";
        try{
            PreparedStatement pstmt = conn.prepareStatement(sql);
            rs=pstmt.executeQuery();
            while (rs.next()){
                list.add(new CityVO(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5)));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } return list;

    }

    public void update(CityVO city){
        Connection conn = dbconn.getConn();
        String sql  = "update city set population=? where id=?";

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,city.getPopulation());
            pstmt.setInt(2,city.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           try{ conn.close();
        } catch (SQLException e) {
               e.printStackTrace();
           }
        }
    }

    public void delete(int id){
        Connection conn = dbconn.getConn();
        String sql  = "delete from city where id=?";

        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
