package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table
public class Dog implements Pet {
    @Id
    @GeneratedValue
    private long id;
    @OneToMany
    private User owner;
    private String name;
    private String description;
    private Date dateOfBirth;
    private int price;
    private int rating;

    public Dog(String name, String description, Date dateOfBirth, int price, int rating) {
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.rating = rating;
    }

    @Override
    public User getOwner() {
        return owner;
    }

    @Override
    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public void setPrice(int price) {
        this.price = price;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
