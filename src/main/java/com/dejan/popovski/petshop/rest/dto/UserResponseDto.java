package com.dejan.popovski.petshop.rest.dto;

import com.dejan.popovski.petshop.repository.model.Pet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private int budget;
    private List<Pet> pets;
}
