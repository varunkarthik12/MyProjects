package com.example.search_RestAPI.controller;

import com.example.search_RestAPI.Entity.product;
import com.example.search_RestAPI.service.productService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
@AllArgsConstructor
public class productController {

    private productService productService;

    @PostMapping
    public ResponseEntity<product> createProduct(@RequestBody product p)
    {
        return new ResponseEntity<>(productService.createProduct(p),HttpStatus.CREATED);
    }

    @GetMapping("/search")
    public ResponseEntity<List<product>>searchProductsAPI(@RequestParam String query)
    {
        return new ResponseEntity<>(productService.searchProducts(query), HttpStatus.OK);
    }
}
