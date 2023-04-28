package com.example.baitapCrudApi.service;

import com.example.baitapCrudApi.entity.Users;
import com.example.baitapCrudApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<Users> addUser(Users users) {
        if(users != null){
            users.setPassword(passwordEncoder.encode(users.getPassword()));
            return Optional.of(userRepository.save(users));
        }
        return null;
    }

    @Override
    public Optional<Users> updateUser(int id, Users users) {
        if(users != null){
            Users users1 = userRepository.getById(id);
            if (users1 != null){
                users1.setEmail(users.getEmail());
                users1.setFullname(users.getFullname());
                users1.setPhone(users.getPhone());
                users1.setPassword(passwordEncoder.encode(users.getPassword()));
                users1.setRole(users.getRole());

                return Optional.of(userRepository.save(users1));
            }
        }
        return null;
    }

    @Override
    public boolean deleteUser(int id) {
        if (id >= 1){
            Users users = userRepository.getById(id);
            if(users != null){
                userRepository.delete(users);
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Users> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> getOneUser(int id) {
        return Optional.of(userRepository.findById(id).get());
    }

    @Override
    public Page<Users> findPaginated(int pageNo, int pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.Direction.ASC, sortBy);
        Page<Users> pagedResult = userRepository.findAll(paging);

        return pagedResult;
    }
}
