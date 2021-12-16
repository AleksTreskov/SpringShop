package ru.gb.shop.inventory.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_DISCOUNTS")
@Data
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "original_value", nullable = false)
    private double originalValue;

}
