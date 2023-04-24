package com.example.baitap1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Bạn chưa nhập Email")
    @Email(message = "Email không hợp lệ")
    private String email;

    @NotBlank(message = "Bạn chưa nhập tên đầy đủ")
    private String fullname;

    @Size(min = 10,max =11 , message = "Tên bạn phải từ 10 kí tự trở lên")
    private String phone;

    @NotBlank(message = "Bạn chưa nhập mật khẩu")
    private String password;

    private String role;
}
