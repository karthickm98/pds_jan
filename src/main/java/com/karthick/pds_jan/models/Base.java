package com.karthick.pds_jan.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Base {
    private long id;
    private Date createdAt;
    private Date updatedAt;
}
