package com.valdirsantos714.apiproducts.controllers;

import com.valdirsantos714.apiproducts.payloads.ProductDto;
import com.valdirsantos714.apiproducts.model.Product;
import com.valdirsantos714.apiproducts.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity findAllProducts() {
        List<Product> list = productService.findAll();

        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity findByIdProduct(@PathVariable Long id) {
        Product product = productService.findById(id);

        return ResponseEntity.ok().body(product);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity updateProduct(@PathVariable Long id, @RequestBody @Valid ProductDto productDto) {
        var product = new Product(productDto);
        product = productService.update(id, productDto);

        return ResponseEntity.ok().body(product);
    }

    @PostMapping
    public ResponseEntity saveProduct(@RequestBody @Valid ProductDto productDto) {

        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(productDto));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
