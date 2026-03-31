package com.karthick.pds_jan.models;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Category extends Base{
    private String name;
    private String description;
//    public Category(String name, String description) {
//        this.name = name;
//        this.description = description;
//    }
}
