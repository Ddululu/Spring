package com.example.demo.service;

import com.example.demo.dao.ScopeDAO;
import com.example.demo.vo.Scope;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeService {
    @Autowired
    private ScopeDAO dao;

    // public Member select(String id)
    public Scope getAccount(String id) throws Exception {
        return dao.select(id);
    }
    //public void insert(Member m)
    public void signUp(Scope scope) {
        dao.insert(scope);
    }

    //public void update(Member m){
    public void setAccount(Scope scope) {
        dao.update(scope);
    }

    //public void delete(Member m){
    public void deleteAccount(Scope scope) {
        dao.delete(scope);
    }
}
