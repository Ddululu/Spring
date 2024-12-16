package com.example.security.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserDao dao;
    @Autowired
    private PasswordEncoder encoder;

    //추가, 수정
    public void save(UserDto user) {
        Users Entity= new Users(user.getId(), encoder.encode(user.getPassword()));
        dao.save(Entity);
    }
    public UserDto get(String id){
        Users Entity= dao.findById(id).orElseThrow(()->new UsernameNotFoundException("사용자 찾을 수 없음."));
        UserDto dto= new UserDto();
        dto.setId(Entity.getId());
        dto.setPassword(Entity.getPassword());
        return dto;
    }
}
