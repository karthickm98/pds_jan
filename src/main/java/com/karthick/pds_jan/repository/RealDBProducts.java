package com.karthick.pds_jan.repository;

import com.karthick.pds_jan.models.Product;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RealDBProducts extends JpaRepository<Product, Long> {
    List<Product> getProductsById(long id);

    @Override
    List<Product> findAll();

    @Override
    List<Product> findAll(Sort sort);
}

