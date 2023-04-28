package com.example.baitapCrudApi.service;

import com.example.baitapCrudApi.entity.Users;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;

public interface UserService {
    //Ham them nguoi nguoi
    public Optional<Users> addUser(Users users);

    //Ham chinh sua thong tin nguoi dung
    public Optional<Users> updateUser(int id, Users users);

    //Ham xoa nguoi dung
    public boolean deleteUser(int id);

    //Ham lay ra danh sach nguoi dung
    public List<Users> getAllUser();

    //Ham lay ra 1 nguoi dung
    public Optional<Users> getOneUser(int id);

    Page<Users> findPaginated(int pageNo, int pageSize, String sortBy);
}
