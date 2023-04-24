package com.example.baitap1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "contact")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private int id;

    @NotNull
    @Size(min = 2,max =10 , message = "Tên bạn phải từ 2 kí tự trở lên")
    private String name;

    @NotEmpty(message = "Bạn chưa nhập Email")
    @Email(message = "Email của bạn không hợp lệ")
    private String email;

    @NotBlank(message = "Bạn chưa nhập tiêu đề")
    private String subject;

//    @Length(min = 6, message = "Password phải từ 6 kí tự trở lên")
    @Min(value = 6, message = "Tin nhắn của bạn phải từ 6 kí tự trở lên")
    private String message;

}
