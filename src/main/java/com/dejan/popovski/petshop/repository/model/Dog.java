package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table
@NoArgsConstructor
@Getter
@Setter
public class Dog extends Pet {
    @Min(1)
    @Max(10)
    private int rating;

    public Dog(String name, String description, Date dateOfBirth, int rating) {
        super(name, description, dateOfBirth);
        this.rating = rating;
        this.setPrice(calculatePrice(dateOfBirth));
    }

    @Override
    protected int calculatePrice(Date dateOfBirth) {
        return super.calculatePrice(dateOfBirth) + rating;
    }
}
