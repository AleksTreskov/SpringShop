package ru.gb.shop.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.exception.NoContentException;
import ru.gb.shop.inventory.entity.Product;
import ru.gb.shop.inventory.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll().parallelStream().toList();
    }

    public Product findById(long id) {
        try {
            return productRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Product entity not found by id %d", id), e);
        }
    }

    public void deleteById(long id) {
        try {
            productRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Product entity %d not exist.", id), e);
        }

    }

    public void saveProduct(Product product) {
        try {
            productRepository.save(product);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Product entity %d not exist.", product.getId()), e);
        }
    }
}
