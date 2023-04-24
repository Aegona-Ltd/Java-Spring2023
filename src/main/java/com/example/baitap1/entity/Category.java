package com.example.baitap1.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private int id;

    @ManyToOne
    @JoinColumn(name="category_description_id", nullable = false)
    private CategoryDescription categoryDescription;

    @Column(name = "image")
    private String image;
}
