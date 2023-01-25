package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Cat extends Pet {
    public Cat(String name, String description, Date dateOfBirth, int price) {
        setName(name);
        setDescription(description);
        setDateOfBirth(dateOfBirth);
        setPrice(price);
    }
}
