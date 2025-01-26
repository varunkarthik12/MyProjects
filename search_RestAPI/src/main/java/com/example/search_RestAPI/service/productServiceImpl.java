package com.example.search_RestAPI.service;

import com.example.search_RestAPI.Entity.product;
import com.example.search_RestAPI.Repository.productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
@AllArgsConstructor
public class productServiceImpl implements  productService {

    private productRepository productRep;

    @Override
    public product createProduct(product p) {

        return (product) productRep.save(p);

    }

    @Override
    public List<product> searchProducts(String query) {

        List<product> prod_list = productRep.searchProductsSQL(query);

        return prod_list;
    }
}
