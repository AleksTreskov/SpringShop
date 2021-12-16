package ru.gb.shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shop.inventory.entity.ProductCategory;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
