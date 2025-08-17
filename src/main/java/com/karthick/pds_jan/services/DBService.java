package com.karthick.pds_jan.services;

import com.karthick.pds_jan.models.Product;

import java.util.List;

import org.springframework.stereotype.Service;

@Service("realdb")
public class DBService implements IProductService {

    @Override
    public Product getSingleProduct(long id) {
        System.out.println("get product by id");
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        System.out.println("get list of all products");
        return List.of();
    }

    @Override
    public Product replaceProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        System.out.println(" replace products");
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        // TODO Auto-generated method stub
        System.out.println(" update products");
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        // TODO Auto-generated method stub
        System.out.println(" create product");
        return null;
        // throw new UnsupportedOperationException("Unimplemented method 'createProduct'");
    }

    @Override
    public Product deleteProduct(Long id) {
        // TODO Auto-generated method stub
        System.out.println(" delete product");
        return null;
        // throw new UnsupportedOperationException("Unimplemented method 'deleProduct'");
    }
}
