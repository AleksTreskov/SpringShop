package ru.gb.shop.inventory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.shop.inventory.entity.ProductCategory;
import ru.gb.shop.inventory.service.ProductCategoryService;

import java.util.List;

@RestController
@RequestMapping("/product_categories")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    public ProductCategoryController(ProductCategoryService productCategoryService) {
        this.productCategoryService = productCategoryService;
    }


    @GetMapping
    public ResponseEntity<List<ProductCategory>> findAll() {
        return ResponseEntity.ok(productCategoryService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductCategory> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productCategoryService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<String> saveNewProductCategory(@RequestBody ProductCategory category) {
        productCategoryService.saveProductCategory(category);
        return new ResponseEntity<>("Successfully created.", HttpStatus.CREATED);

    }
    @PutMapping("/edit")
    public ResponseEntity<ProductCategory> updateRole(@RequestBody ProductCategory category) {
        productCategoryService.saveProductCategory(category);
        return ResponseEntity.ok(category);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        productCategoryService.deleteById(id);
        return ResponseEntity.ok("Deleted.");
    }
}

