package ru.gb.shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shop.inventory.entity.ProductPrice;

public interface ProductPriceRepository extends JpaRepository<ProductPrice,Long> {
}
