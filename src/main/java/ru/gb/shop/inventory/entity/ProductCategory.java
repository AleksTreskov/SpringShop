package ru.gb.shop.inventory.entity;

import lombok.Data;

import javax.persistence.*;
@Table(name = "PRODUCT_CATEGORIES")
@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name",nullable = false,unique = true, columnDefinition = "VARCHAR(20)", length = 50)
    private String name;
}
