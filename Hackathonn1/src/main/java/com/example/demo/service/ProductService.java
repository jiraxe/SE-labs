package com.example.demo.service;

import com.example.demo.dao.ProductRepository;
import com.example.demo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService{

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public void addProduct(Product product) {
        this.productRepository.save(product);
    }
}
