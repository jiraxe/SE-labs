package com.example.demo.dao;

import com.example.demo.model.Product;
import com.example.demo.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

}
