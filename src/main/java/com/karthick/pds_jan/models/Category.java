package com.karthick.pds_jan.models;

public class Category extends Base{
    private String name;
    private String description;
    public Category(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
