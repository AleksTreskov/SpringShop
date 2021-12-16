package ru.gb.shop.inventory.web.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.shop.inventory.entity.Product;
import ru.gb.shop.inventory.entity.Role;
import ru.gb.shop.inventory.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Product> saveNewProduct(@RequestBody Product product) {
        productService.saveProduct(product);
        return new ResponseEntity<>(productService.findById(product.getId()),HttpStatus.CREATED);

    }
    @PutMapping("/edit")
    public ResponseEntity<Product> updateRole(@RequestBody Product product) {
        productService.saveProduct(product);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") long id) {
        productService.deleteById(id);
        return ResponseEntity.ok("Deleted.");
    }
}
