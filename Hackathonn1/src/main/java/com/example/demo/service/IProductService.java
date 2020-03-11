package com.example.demo.service;

import com.example.demo.model.Product;

import java.util.List;

public interface IProductService {
    List<Product> getAllProducts();

    void addProduct(Product product);
}
