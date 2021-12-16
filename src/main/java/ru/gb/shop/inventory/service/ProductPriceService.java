package ru.gb.shop.inventory.service;

import org.springframework.stereotype.Service;
import ru.gb.shop.inventory.exception.EntityNotFoundException;
import ru.gb.shop.inventory.entity.ProductPrice;
import ru.gb.shop.inventory.repository.ProductPriceRepository;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductPriceService {
    private final ProductPriceRepository productPriceRepository;

    public ProductPriceService(ProductPriceRepository productPriceRepository) {
        this.productPriceRepository = productPriceRepository;
    }

    public List<ProductPrice> findAll() {
        return productPriceRepository.findAll().parallelStream().toList();
    }

    public ProductPrice findById(long id) {
        try {
            return productPriceRepository.findById(id).orElseThrow();
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Price not found by id %d", id), e);
        }
    }

    public void deleteById(long id) {
        try {
            productPriceRepository.deleteById(id);
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Price not found by id %d", id), e);
        }
    }

    public void saveProductPrice(ProductPrice productPrice) {
        try {
            productPriceRepository.save(productPrice);
        } catch (NoSuchElementException e) {
            throw new EntityNotFoundException(String.format("Price not found by id %d", productPrice.getId()), e);
        }
    }
}
