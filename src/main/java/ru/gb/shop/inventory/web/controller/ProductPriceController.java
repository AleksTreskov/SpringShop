package ru.gb.shop.inventory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.shop.inventory.entity.ProductPrice;
import ru.gb.shop.inventory.service.ProductPriceService;

import java.util.List;

@RestController
@RequestMapping("/product_prices")
public class ProductPriceController {
    private final ProductPriceService productPriceService;

    public ProductPriceController(ProductPriceService productPriceService) {
        this.productPriceService = productPriceService;
    }

    @GetMapping
    public ResponseEntity<List<ProductPrice>> findAll() {
        return ResponseEntity.ok(productPriceService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductPrice> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productPriceService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<String> saveNewProductPrice(@RequestBody ProductPrice price) {
        productPriceService.saveProductPrice(price);
        return new ResponseEntity<>("Successfully created.", HttpStatus.CREATED);

    }
    @PutMapping("/edit")
    public ResponseEntity<ProductPrice> updateProductPrice(@RequestBody ProductPrice price) {
        productPriceService.saveProductPrice(price);
        return ResponseEntity.ok(price);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        productPriceService.deleteById(id);
        return ResponseEntity.ok("Deleted.");
    }
}
