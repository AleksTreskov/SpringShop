package ru.gb.shop.inventory.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Table(name = "PRODUCTS")
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false, unique = true, columnDefinition = "VARCHAR(20)", length = 50)
    private String name;
    @ManyToMany
    @JoinTable(name = "PRODUCTS_CATEGORIES",
            joinColumns = @JoinColumn(name = "product_id", nullable = false,
                    foreignKey = @ForeignKey(name = "   FK_product_category_product_id", foreignKeyDefinition = "FOREIGN KEY (product_id) REFERENCES products(id) ON DELETE NO ACTION ON UPDATE NO ACTION")),
            inverseJoinColumns = @JoinColumn(name = "category_id", nullable = false,
                    foreignKey = @ForeignKey(name = "FK_product_category_category_id", foreignKeyDefinition = "FOREIGN KEY (category_id) REFERENCES product_categories(id) ON DELETE NO ACTION ON UPDATE NO ACTION")))
    private List<ProductCategory> productCategory;

    @ManyToOne
    @JoinColumn(name = "price_id", nullable = false, foreignKey = @ForeignKey(name = "FK_product_price_product_id"))
    private ProductPrice price;
    @ManyToOne
    @JoinColumn(name = "discount_id", foreignKey = @ForeignKey(name = "FK_discount_price_product_id"))
    private ProductDiscount discount;

}
