package com.paymentchain.product.controller;

import com.paymentchain.product.entities.Product;
import com.paymentchain.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductRestController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping
    public List<Product> list() {
        return productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product get(@PathVariable long id) {
        return productRepository.findById(id).get();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> put(@PathVariable long id, @RequestBody Product product) {
        Product product1 = productRepository.save(product);
        return ResponseEntity.ok(product1);
    }

    @PostMapping
    public ResponseEntity<Product> post(@RequestBody Product product) {
        Product product1 = productRepository.save(product);
        return ResponseEntity.ok(product1);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> delete(@PathVariable long id) {
        Optional<Product> findById = productRepository.findById(id);
        if (findById.get() != null) {
            productRepository.delete(findById.get());
        }
        return ResponseEntity.ok().build();
    }
}
