package com.example.market.user;


public interface UserService {
    void joinUser(UserDto userDto) throws IllegalAccessException;
    void updateUser(UserDto userDto);
    Boolean checkUser(UserDto userDto);
}
