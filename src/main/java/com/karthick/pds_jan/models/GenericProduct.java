package com.karthick.pds_jan.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
public class GenericProduct {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int price;

    public GenericProduct(String name, int price) {
        this.name = name;
        this.price = price;
    }
}
