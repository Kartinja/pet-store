package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table
public class Dog extends Pet {
    private int rating;

    public Dog(String name, String description, Date dateOfBirth, int price, int rating) {
        setName(name);
        setDescription(description);
        setDateOfBirth(dateOfBirth);
        setPrice(price);
        setRating(rating);
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
