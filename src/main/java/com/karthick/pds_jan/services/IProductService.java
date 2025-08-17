package com.karthick.pds_jan.services;

import com.karthick.pds_jan.models.Product;

import java.util.List;

public interface IProductService {
    Product getSingleProduct(long id);

    List<Product> getAllProducts();

    Product replaceProduct(Long id, Product product);

    Product createProduct(Product product);

    Product deleteProduct(Long id);

    Product updateProduct(Long id, Product product);
}
