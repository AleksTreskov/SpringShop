package ru.gb.shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shop.inventory.entity.ProductDiscount;

public interface ProductDiscountRepository extends JpaRepository<ProductDiscount,Long> {
}
