package com.example.demo.service;

import com.example.demo.model.Supplier;

import java.util.List;

public interface ISupplierService {

    List<Supplier> getAllSuppliers();

    void addSupplier(Supplier supplier);
}
