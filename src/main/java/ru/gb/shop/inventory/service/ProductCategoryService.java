package ru.gb.shop.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.exception.NoContentException;
import ru.gb.shop.inventory.entity.ProductCategory;
import ru.gb.shop.inventory.repository.ProductCategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.StreamSupport;

@Service
public class ProductCategoryService {
    private final ProductCategoryRepository productCategoryRepository;

    public ProductCategoryService(ProductCategoryRepository productCategoryRepository) {
        this.productCategoryRepository = productCategoryRepository;
    }
    public List<ProductCategory> findAll() {
        return productCategoryRepository.findAll().parallelStream().toList();
    }

    public ProductCategory findById(long id) {
        try {
            return productCategoryRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Category not found by id %d", id), e);
        }
    }

    public void deleteById(long id) {
        try {
            productCategoryRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Category not found by id %d", id), e);
        }
    }

    public void saveProductCategory(ProductCategory productCategory) {
        try {
            productCategoryRepository.save(productCategory);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Category not found by id %d", productCategory.getId()), e);
        }
    }}
