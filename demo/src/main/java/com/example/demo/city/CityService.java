package com.example.demo.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {
    @Autowired
    private CityDao dao;

    public CityVO getCity(int id){
        return dao.select(id);
    }

    public void add(CityVO city){
        dao.insert(city);
    }

    public ArrayList<CityVO> getAll(){
        return dao.selectAll();
    }

    public void edit(CityVO city){
        dao.update(city);
    }

    public void delete(int id){
        dao.delete(id);
    }
}
