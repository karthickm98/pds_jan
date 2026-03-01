package com.karthick.pds_jan.dtos;


import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GetInstructorDto {

    private UUID id;
    private String name;
    private String email;
    private List<Long> batchId;
    private List<String> batchName;
}
