package com.example.search_RestAPI.service;

import com.example.search_RestAPI.Entity.product;
import com.example.search_RestAPI.Repository.productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


public interface productService {


    public product createProduct(product p);

    public List<product> searchProducts(String query);

}
