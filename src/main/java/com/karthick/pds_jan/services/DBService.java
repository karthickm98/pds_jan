package com.karthick.pds_jan.services;

import com.karthick.pds_jan.models.Product;
import com.karthick.pds_jan.repository.RealDBProducts;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Qualifier("DatabaseService")
public class DBService implements ProductService {
    RealDBProducts realDBProducts;

    @Override
    public Product getSingleProduct(long id) {
        List<Product> p1 = realDBProducts.getProductsById(id);
        return p1.get(0);
    }

    @Override
    public List<Product> getAllProducts() {
        return realDBProducts.findAll();
    }
    // @Override
    // public List<Product> getLimitedProducts(Integer num) {
    // return null;
    // // TODO Auto-generated method stub
    // // throw new UnsupportedOperationException("Unimplemented method
    // 'getLimitedProducts'");
    // }

    @Override
    public Product replaceProduct(Long id, Product product) {
        product.setId(id);
        return realDBProducts.save(product);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = realDBProducts.findById(id).orElse(null);
        if (existingProduct == null) {
            return null;
        }
        if (product.getTitle() != null) {
            existingProduct.setTitle(product.getTitle());
        }
        if (product.getPrice() != 0.0) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getCategory() != null) {
            existingProduct.setCategory(product.getCategory());
        }
        return realDBProducts.save(existingProduct);
    }

    @Override
    public Product createProduct(Product product) {
        return realDBProducts.save(product);
    }
}
