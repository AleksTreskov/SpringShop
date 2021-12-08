package ru.gb.shop.inventory.ProductEntity;

import lombok.Data;

import javax.persistence.*;
@Entity
@Table(name = "PRODUCT_PRICES")
@Data
public class ProductPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_idGenerator")
    @SequenceGenerator(name = "seq_idGenerator", sequenceName = "seq_productPriceId", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "original_value", nullable = false)
    private double originalValue;

}
