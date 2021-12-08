package ru.gb.shop.inventory.ProductEntity;

import lombok.Data;

import javax.persistence.*;
@Table(name = "PRODUCT_CATEGORIES")
@Entity
@Data
public class ProductCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_idGenerator")
    @SequenceGenerator(name = "seq_idGenerator", sequenceName = "seq_productCategoryId", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "name",nullable = false, columnDefinition = "VARCHAR(20)", length = 50)
    private String name;
}
