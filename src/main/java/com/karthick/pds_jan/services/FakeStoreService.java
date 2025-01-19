package com.karthick.pds_jan.services;

import com.karthick.pds_jan.dtos.FakeStoreDTO;
import com.karthick.pds_jan.models.Category;
import com.karthick.pds_jan.models.Product;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreService implements ProductService{
    RestTemplate restTemplate;

    FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreDTO fsDTO =
                restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                        FakeStoreDTO.class);
        return convertFakeStoreDTOToProduct(fsDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreDTO[] fsDTOList =
                restTemplate.getForObject("https://fakestoreapi.com/products/" ,
                        FakeStoreDTO[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreDTO fsdto : fsDTOList) {
            products.add(convertFakeStoreDTOToProduct(fsdto));
        }
        return products;
    }

    private Product convertFakeStoreDTOToProduct(FakeStoreDTO fsDTO) {

        Product product = new Product();
        product.setId(fsDTO.getId());
        product.setTitle(fsDTO.getTitle());
        product.setPrice(fsDTO.getPrice());
        Category ct = new Category(fsDTO.getCategory(), fsDTO.getDescription());
        product.setCategory(ct);
        return product;
    }
}
