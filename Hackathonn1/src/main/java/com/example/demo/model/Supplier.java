package com.example.demo.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Supplier {

    @Id
    @GeneratedValue
    private int supplierId;

    private int supplierNumber;

    private String name;

    private String contactPhoneNumber;

    @OneToMany(mappedBy = "supplier",cascade = CascadeType.ALL)
    private List<Product> products = new ArrayList<>();

    public Supplier() {
    }


    public Supplier(int supplierNumber, String name, String contactPhoneNumber) {
        this.supplierNumber = supplierNumber;
        this.name = name;
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public void setSupplierNumber(int supplierNumber) {
        this.supplierNumber = supplierNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }


    public int getSupplierId() {
        return supplierId;
    }

    public int getSupplierNumber() {
        return supplierNumber;
    }

    public String getName() {
        return name;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public List<Product> getProducts() {
        return products;
    }
}
