package com.example.baitap1.service;

import com.example.baitap1.entity.Users;

public interface UserService {

    boolean login(String email, String password);

    public Users createUsers(Users users);

    public Users findByEmail(String email);
}
