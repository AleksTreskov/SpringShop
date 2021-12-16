package ru.gb.shop.inventory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.shop.inventory.entity.ProductDiscount;
import ru.gb.shop.inventory.service.ProductDiscountService;

import java.util.List;

@RestController
@RequestMapping("/product_discounts")
public class ProductDiscountController {
    private final ProductDiscountService productDiscountService;

    public ProductDiscountController(ProductDiscountService productDiscountService) {
        this.productDiscountService = productDiscountService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDiscount>> findAll() {
        return ResponseEntity.ok(productDiscountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDiscount> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productDiscountService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<String> saveNewProductDiscount(@RequestBody ProductDiscount discount) {
        productDiscountService.saveProductDiscount(discount);
        return new ResponseEntity<>("Successfully created.", HttpStatus.CREATED);

    }
    @PutMapping("/edit")
    public ResponseEntity<ProductDiscount> updateRole(@RequestBody ProductDiscount discount) {
        productDiscountService.saveProductDiscount(discount);
        return ResponseEntity.ok(discount);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        productDiscountService.deleteById(id);
        return ResponseEntity.ok("Deleted.");
    }
}

