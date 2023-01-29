package com.dejan.popovski.petshop.rest.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class PetResponseDto {
    private long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;
    @NotNull
    private Date dateOfBirth;
    @NotBlank
    private String type;
    private UserResponseDto owner;

    public PetResponseDto(long id, String name, String description, Date dateOfBirth, int price, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateOfBirth = dateOfBirth;
        this.price = price;
        this.type = type;
        this.owner = new UserResponseDto();
    }

    @Min(0)
    private int price;
}
