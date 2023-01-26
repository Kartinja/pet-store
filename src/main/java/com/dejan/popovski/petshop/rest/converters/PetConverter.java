package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.dto.PetResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PetConverter {
    private UserConverter userConverter;

    public PetResponseDto from(Pet pet) {
        if (pet.getOwner() == null) {
            return new PetResponseDto(pet.getId(), pet.getName(), pet.getDescription(), pet.getDateOfBirth(), pet.getPrice());
        }
        return new PetResponseDto(pet.getId(), pet.getName(), pet.getDescription(), pet.getDateOfBirth(), userConverter.from(pet.getOwner()), pet.getPrice());
    }
}
