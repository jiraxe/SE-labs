package com.example.demo.service;

import com.example.demo.dao.SupplierRepository;
import com.example.demo.model.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService implements ISupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    @Override
    public List<Supplier> getAllSuppliers() {
        return this.supplierRepository.findAll();
    }

    @Override
    public void addSupplier(Supplier supplier) {
        this.supplierRepository.save(supplier);
    }
}
