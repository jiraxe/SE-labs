package com.example.demo.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Product {


    @Id
    @GeneratedValue
    private long productId;

    private long productNumber;

    private String name;

    private double unitPrice;

    private int quantityInStock;

    private LocalDate dateSupplied;

    @ManyToOne
    private Supplier supplier;

    public Product() {
    }

    public Product(long productNumber, String name, double unitPrice, int quantityInStock, LocalDate dateSupplied) {
        this.productNumber = productNumber;
        this.name = name;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
        this.dateSupplied = dateSupplied;
    }

    public void setProductNumber(long productNumber) {
        this.productNumber = productNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setDateSupplied(LocalDate dateSupplied) {
        this.dateSupplied = dateSupplied;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public long getProductId() {
        return productId;
    }

    public long getProductNumber() {
        return productNumber;
    }

    public String getName() {
        return name;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public LocalDate getDateSupplied() {
        return dateSupplied;
    }

    public Supplier getSupplier() {
        return supplier;
    }
}
