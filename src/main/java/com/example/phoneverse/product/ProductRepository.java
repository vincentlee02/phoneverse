package com.example.phoneverse.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String>{
    @Query("SELECT count(p) FROM Product p WHERE p.itemName = :name AND p.storage = :storage AND p.status = 'Ready'")
    long getProductCount(@Param("name") String itemName, @Param("storage") String storage);

    @Query("SELECT p FROM Product p WHERE p.itemName = :name AND p.storage = :storage AND p.status = 'Ready'")
    List<Product> getSearchedProducts(@Param("name") String itemName, @Param("storage") String storage);
}
