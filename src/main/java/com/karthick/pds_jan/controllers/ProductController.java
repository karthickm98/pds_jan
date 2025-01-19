package com.karthick.pds_jan.controllers;

import com.karthick.pds_jan.models.Product;
import com.karthick.pds_jan.services.ProductService;


import org.springframework.web.bind.annotation.*;

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
    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return ps.replaceProduct(id, product); 
    }
    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ps.updateProduct(id, product); 

    }

}
