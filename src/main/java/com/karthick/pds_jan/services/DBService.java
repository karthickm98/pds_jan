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

    @Override
    public List<Product> getLimitedProducts(Integer num) {
        return null;
        // TODO Auto-generated method stub
        // throw new UnsupportedOperationException("Unimplemented method 'getLimitedProducts'");
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        return null;
    }
}
