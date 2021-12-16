package ru.gb.shop.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.exception.NoContentException;
import ru.gb.shop.inventory.entity.ProductDiscount;
import ru.gb.shop.inventory.repository.ProductDiscountRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductDiscountService {
    private final ProductDiscountRepository productDiscountRepository;

    public ProductDiscountService(ProductDiscountRepository productDiscountRepository) {
        this.productDiscountRepository = productDiscountRepository;
    }

    public List<ProductDiscount> findAll() {
        return productDiscountRepository.findAll().parallelStream().toList();
    }

    public ProductDiscount findById(long id) {
        try {
            return productDiscountRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Discount not found by id %d", id), e);
        }
    }
    public void saveProductDiscount(ProductDiscount productDiscount) {
        try {
            productDiscountRepository.save(productDiscount);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Discount not found by id %d", productDiscount.getId()), e);
        }
    }
    public void deleteById(long id) {
        try {
            productDiscountRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new NoContentException(String.format("Discount not found by id %d", id), e);
        }
    }


}
