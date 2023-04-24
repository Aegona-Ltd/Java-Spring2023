package com.example.baitap1.service;

import com.example.baitap1.entity.Users;
import com.example.baitap1.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public boolean login(String email, String password) {
        Users users = userRepository.findByEmail(email);
        if (users == null) {

        }
        return false;
    }

    @Override
    public Users createUsers(Users users) {
        users.setPassword(passwordEncoder.encode(users.getPassword()));
        users.setRole("ROLE_USER");
        return userRepository.save(users);
    }

    @Override
    public Users findByEmail(String email) {
//        Users user = new Users();
//        PasswordEncoder passwordEncoder= new BCryptPasswordEncoder();
//        passwordEncoder.encode(user.getPassword());
//        user.getEmail();
        return userRepository.findByEmail(email);
    }
}
//    PasswordEncoder passwordEncoder= new BCryptPasswordEncoder() ;
//
//        passwordEncoder.encode(users.getPassword());
//                System.out.println(users.getPassword());
//                System.out.println(passwordEncoder.encode(users.getPassword()));
//                String a= passwordEncoder.encode(users.getPassword());
//                users.setPassword(a);
//                users.setRole("ROLE_USER");
//
//                userRepository.save(users);
//
//                System.out.println("user:" + users);