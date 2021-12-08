package ru.gb.shop.inventory.ProductEntity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "PRODUCT_DISCOUNT")
@Data
public class ProductDiscount {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_idGenerator")
    @SequenceGenerator(name = "seq_idGenerator", sequenceName = "seq_productDiscountId", allocationSize = 1)
    @Column(name = "id")
    private long id;
    @Column(name = "original_value", nullable = false)
    private double originalValue;

}
