package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@MappedSuperclass
public abstract class Pet {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private User owner;
    private String name;
    private String description;
    private Date dateOfBirth;
    private int price;

}
