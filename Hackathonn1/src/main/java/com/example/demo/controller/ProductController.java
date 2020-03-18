package com.example.demo.controller;


import com.example.demo.model.Product;
import com.example.demo.model.Supplier;
import com.example.demo.service.IProductService;
import com.example.demo.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value="/product")
public class ProductController {

    @Autowired
    IProductService iProductService;
    @Autowired
    ISupplierService iSupplierService;

    @GetMapping(value = {"/x"})
    public List<Product> listProduct() {
        return this.iProductService.getAllProducts();
    }
    @GetMapping(value="")
    ModelAndView getAllProducts()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("products",this.iProductService.getAllProducts());
        modelAndView.setViewName("listProduct");
        return modelAndView;
    }
    @GetMapping(value="/add")
    ModelAndView  addProduct()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("product",new Product());
        modelAndView.addObject("suppliers",this.iSupplierService.getAllSuppliers());
        modelAndView.setViewName("createProduct");
        return modelAndView;
    }

    @PostMapping(value = "/add")
    public void registerStudent(@ModelAttribute("product") Product product, HttpServletResponse response) throws IOException {

        this.iProductService.addProduct(product);
        response.sendRedirect("/supplier/");
    }

}
