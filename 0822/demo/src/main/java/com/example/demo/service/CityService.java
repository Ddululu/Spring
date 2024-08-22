package com.example.demo.service;

import com.example.demo.dao.CityDao;
import com.example.demo.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CityService {
    @Autowired
    private CityDao dao;

    public City getCity(int id){
        return dao.select(id);
    }

    public void add(City city){
        dao.insert(city);
    }

    public ArrayList<City> getAll(){
        return dao.selectAll();
    }

    public void edit(City city){
        dao.update(city);
    }

    public void delete(int id){
        dao.delete(id);
    }
}
