package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private User owner;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Date dateOfBirth;
    @Min(1)
    private int price;

    public Pet(String name, String description, Date dateOfBirth) {
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = calculatePrice(dateOfBirth);
    }

    protected int calculatePrice(Date dateOfBirth) {
        LocalDate today = LocalDate.now();
        LocalDate birth = LocalDate.of(dateOfBirth.getYear(), dateOfBirth.getMonth(), dateOfBirth.getDate());
        Period period = Period.between(birth, today);
        return period.getYears();
    }

    ;
}
