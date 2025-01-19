package com.karthick.pds_jan.controllers;

import com.karthick.pds_jan.models.Product;
import com.karthick.pds_jan.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService ps;

    ProductController( ProductService ps){
        this.ps = ps;
    }
    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return  ps.getSingleProduct(id);
    }
    @GetMapping()
    public List<Product> getSingleProduct(){
        return  ps.getAllProducts();
    }
}
