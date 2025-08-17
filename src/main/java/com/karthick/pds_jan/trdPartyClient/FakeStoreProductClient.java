package com.karthick.pds_jan.trdPartyClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.karthick.pds_jan.dtos.FakeStoreDTO;
import com.karthick.pds_jan.models.Product;
// import com.karthick.pds_jan.trdPartyClient.dtos.fsProductDTO;

@Component
public class FakeStoreProductClient {

    // @Value("${fakeStore.api.baseUrl}")
    // private String baseUrl;

    private final String productPath = "/products";

    private String baseUrl = "";
    private RestTemplateBuilder restTemplateBuilder;

    @Autowired
    public FakeStoreProductClient(@Value("${fakeStore.api.baseUrl}") String baseUrl,
            RestTemplateBuilder restTemplateBuilder) {
        this.baseUrl = baseUrl;
        this.restTemplateBuilder = restTemplateBuilder;
    }

    public FakeStoreDTO createProduct(Product product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDTO> response = restTemplate.postForEntity(baseUrl + productPath, product,
                FakeStoreDTO.class);

        FakeStoreDTO fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }

    public FakeStoreDTO deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreDTO> response = restTemplate.exchange(baseUrl + productPath + "/{id}",
                HttpMethod.DELETE,
                null,
                FakeStoreDTO.class, id);
        FakeStoreDTO fakeStoreProductDto = response.getBody();
        return fakeStoreProductDto;
    }

}
