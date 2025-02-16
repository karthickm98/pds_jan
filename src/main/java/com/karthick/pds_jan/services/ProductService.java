package com.karthick.pds_jan.services;

import com.karthick.pds_jan.models.Product;

import java.util.List;

public interface ProductService {
    Product getSingleProduct(long id);
    List<Product> getAllProducts();
    List<Product> getLimitedProducts(Integer num);
    Product replaceProduct(Long id, Product product);
    Product updateProduct(Long id, Product product);
}
