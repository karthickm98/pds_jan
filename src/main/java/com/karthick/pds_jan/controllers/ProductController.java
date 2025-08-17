package com.karthick.pds_jan.controllers;

import com.karthick.pds_jan.models.Product;
import com.karthick.pds_jan.services.IProductService;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    IProductService ps;
    
    // qualifier
    // fakeStoreService==> fake store api
    // realdb ==> rd local db
    ProductController(@Qualifier("realdb") IProductService ps) {
        this.ps = ps;
    }

    @GetMapping("/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id) {
        return ps.getSingleProduct(id);
    }

    @GetMapping()
    public List<Product> getAllProducts() {
        return ps.getAllProducts();
    }

    @PutMapping("/{id}")
    public Product replaceProduct(@PathVariable Long id, @RequestBody Product product) {
        return ps.replaceProduct(id, product);
    }

    @PatchMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        return ps.updateProduct(id, product);

    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        return ps.createProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id) {
        return ps.deleteProduct(id);
    }

}
