package com.example.security.auth;

import com.example.security.user.UserDao;
import com.example.security.user.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserDao dao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = dao.findById(username).orElseThrow(()->new UsernameNotFoundException("사용자 없음."));
        System.out.println("------------------------------------------");
        System.out.println(user);
        System.out.println("------------------------------------------");
        return new UserDetailsImpl(user);
    }
}
