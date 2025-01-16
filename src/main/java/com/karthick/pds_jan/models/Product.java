package com.karthick.pds_jan.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product extends Base{
    private String title;
    private String price;
    private Category category;
}
