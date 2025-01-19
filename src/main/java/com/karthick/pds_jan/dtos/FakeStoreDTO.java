package com.karthick.pds_jan.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakeStoreDTO {
    private long id;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
