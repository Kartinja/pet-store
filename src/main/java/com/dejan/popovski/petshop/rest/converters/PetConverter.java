package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.Cat;
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
        String type;
        if (pet instanceof Cat) {
            type = "Cat";
        } else {
            type = "Dog";
        }
        if (pet.getOwner() == null) {
            return new PetResponseDto(pet.getId(), pet.getName(), pet.getDescription(), pet.getDateOfBirth(), pet.getPrice(), type);
        }
        return new PetResponseDto(pet.getId(), pet.getName(), pet.getDescription(), pet.getDateOfBirth(), type, userConverter.from(pet.getOwner()), pet.getPrice());
    }
}
