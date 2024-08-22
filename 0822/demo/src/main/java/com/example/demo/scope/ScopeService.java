package com.example.demo.scope;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ScopeService {
    @Autowired
    private ScopeDAO dao;

    // public Member select(String id)
    public Member getAccount(String id) throws Exception {
        return dao.select(id);
    }
    //public void insert(Member m)
    public void signUp(Member member) {
        dao.insert(member);
    }

    //public void update(Member m){
    public void setAccount(Member member) {
        dao.update(member);
    }

    //public void delete(Member m){
    public void deleteAccount(Member member) {
        dao.delete(member);
    }
}
