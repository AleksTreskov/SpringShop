package ru.gb.shop.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.shop.inventory.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
