package com.example.demo.controller;


import com.example.demo.model.Supplier;
import com.example.demo.service.IProductService;
import com.example.demo.service.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping(value="/supplier")
public class SupplierController {

    @Autowired
    ISupplierService iSupplierService;

    @GetMapping(value="")
    ModelAndView getAllSuppliers()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("suppliers",this.iSupplierService.getAllSuppliers());
        modelAndView.setViewName("listSupplier");
        return modelAndView;
    }

    @GetMapping(value="/add")
    ModelAndView  addSupplier()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("supplier",new Supplier());
        modelAndView.setViewName("createSupplier");
        return modelAndView;
    }

    @PostMapping(value="/add")
     String registerStudent(@ModelAttribute("supplier") Supplier supplier) throws IOException {
        iSupplierService.addSupplier(supplier);
       return "redirect:/supplier/";
    }
}
