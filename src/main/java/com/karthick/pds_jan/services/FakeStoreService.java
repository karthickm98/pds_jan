package com.karthick.pds_jan.services;

// import com.karthick.pds_jan.FakeStoreProductClient;
import com.karthick.pds_jan.dtos.FakeStoreDTO;
import com.karthick.pds_jan.models.Category;
import com.karthick.pds_jan.models.Product;
import com.karthick.pds_jan.trdPartyClient.FakeStoreProductClient;

import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("fakeStoreService")
public class FakeStoreService implements IProductService {
    RestTemplate restTemplate;
    private FakeStoreProductClient fakeStoreProductClient;

    FakeStoreService(RestTemplate restTemplate, FakeStoreProductClient fakeStoreProductClient) {
        this.restTemplate = restTemplate;
        this.fakeStoreProductClient = fakeStoreProductClient;
    }

    @Override
    public Product getSingleProduct(long id) {
        FakeStoreDTO fsDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                FakeStoreDTO.class);
        return convertFakeStoreDTOToProduct(fsDTO);
    }

    @Override
    public List<Product> getAllProducts() {
        FakeStoreDTO[] fsDTOList = restTemplate.getForObject("https://fakestoreapi.com/products/",
                FakeStoreDTO[].class);
        List<Product> products = new ArrayList<>();
        for (FakeStoreDTO fsdto : fsDTOList) {
            products.add(convertFakeStoreDTOToProduct(fsdto));
        }
        return products;
    }

    @Override // patch method
    public Product updateProduct(Long id, Product product) {
        // TODO create a update method patch ̰
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreDTO.class);
        HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor = new HttpMessageConverterExtractor<>(
                FakeStoreDTO.class, restTemplate.getMessageConverters());
        FakeStoreDTO fsDTO = restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PATCH,
                requestCallback,
                responseExtractor);
        return convertFakeStoreDTOToProduct(fsDTO);

    }

    @Override // put method
    public Product replaceProduct(Long id, Product product) {
        // TODO create a update method put
        RequestCallback requestCallback = restTemplate.httpEntityCallback(product, FakeStoreDTO.class);
        HttpMessageConverterExtractor<FakeStoreDTO> responseExtractor = new HttpMessageConverterExtractor<>(
                FakeStoreDTO.class, restTemplate.getMessageConverters());
        FakeStoreDTO fsDTO = restTemplate.execute(
                "https://fakestoreapi.com/products/" + id,
                HttpMethod.PUT,
                requestCallback,
                responseExtractor);
        return convertFakeStoreDTOToProduct(fsDTO);
    }

    private Product convertFakeStoreDTOToProduct(FakeStoreDTO fsDTO) {

        // Product product = new Product();
        // product.setId(fsDTO.getId());
        // product.setTitle(fsDTO.getTitle());
        // product.setPrice(fsDTO.getPrice());
        // Category ct = new Category(fsDTO.getCategory(), fsDTO.getDescription());
        // product.setCategory(ct);
        // return product;
        Product product = new Product();
        product.setId(fsDTO.getId());
        product.setCategory(new Category(fsDTO.getCategory(), fsDTO.getDescription()));
        product.setTitle(fsDTO.getTitle());
        product.setPrice(fsDTO.getPrice());

        return product;
    }

    @Override
    public Product createProduct(Product product) {
        FakeStoreDTO fsdto = fakeStoreProductClient.createProduct(product);
        return convertFakeStoreDTOToProduct(fsdto);
    }

    @Override
    public Product deleteProduct(Long id) {
        FakeStoreDTO fsdto = fakeStoreProductClient.deleteProduct(id);
        return convertFakeStoreDTOToProduct(fsdto);
    }
}
