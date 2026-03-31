package com.karthick.pds_jan.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends Base{
    private String title;
    private double price;
    // This is non-primitive
    // I have to define a relation between product and category
    // => Cardinality.
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private Category category;
}
