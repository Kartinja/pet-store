package com.dejan.popovski.petshop.rest.dto;

import com.dejan.popovski.petshop.repository.model.Pet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {
    @NotNull
    private long id;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
    @NotNull
    private int budget;
    private List<Pet> pets;
}
