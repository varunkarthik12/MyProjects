package com.example.search_RestAPI.Repository;

import com.example.search_RestAPI.Entity.product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Repository
public interface productRepository extends JpaRepository<product,Long>{

    @Query(value = "SELECT * FROM products p WHERE p.name LIKE CONCAT('%', :query, '%') OR p.description LIKE CONCAT('%', :query, '%')", nativeQuery = true)
    List<product> searchProductsSQL(String query);
}
