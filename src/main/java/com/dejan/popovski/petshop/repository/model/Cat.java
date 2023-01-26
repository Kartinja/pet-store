package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@NoArgsConstructor
public class Cat extends Pet {
    public Cat(String name, String description, Date dateOfBirth) {
        super(name, description, dateOfBirth);
    }
}
