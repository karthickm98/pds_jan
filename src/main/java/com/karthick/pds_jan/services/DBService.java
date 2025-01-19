package com.karthick.pds_jan.services;

import com.karthick.pds_jan.models.Product;

import java.util.List;

public class DBService implements ProductService{

    @Override
    public Product getSingleProduct(long id) {
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }
}
