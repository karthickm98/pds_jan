package com.karthick.pds_jan.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter

//@MappedSuperclass
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
// telling hibernate to create a table for you

public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;
    @Column(name = "email_address", unique = true)
    private String email;
}
