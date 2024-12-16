package com.example.market.user;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repo;
    @Autowired
    private PasswordEncoder encoder;


    @Override
    @Transactional
    public void joinUser(UserDto userDto) throws IllegalAccessException {
        Users users = new Users();
        if(userDto.getUsername().isEmpty()||userDto.getPassword().isEmpty()){throw new IllegalAccessException("잘못된 입력");}
            else {
                users.setUsername(userDto.getUsername());
                users.setPassword(encoder.encode(userDto.getPassword()));
            }
            repo.save(users);
    }

    @Override
    @Transactional
    public void updateUser(UserDto userDto) {
        Users users = repo
                .findByUsername(userDto.getUsername())
                .orElseThrow(EntityNotFoundException::new);
       repo.save(users);
    }

    @Override
    public Boolean checkUser(UserDto userDto) {
        return repo.existsByUsername(userDto.getUsername());
    }

}
