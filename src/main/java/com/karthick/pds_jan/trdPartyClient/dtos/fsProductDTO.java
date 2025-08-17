package com.karthick.pds_jan.trdPartyClient.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class fsProductDTO {
    private Long id;
    private String title;
    private String category;
    private double price;
    private String description;
    private String image;
}