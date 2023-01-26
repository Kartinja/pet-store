package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.rest.dto.PetResponseDto;
import org.springframework.stereotype.Service;

@Service
public class PetConverter {
    public PetResponseDto from(Pet pet){
        return new PetResponseDto(pet.getId(), pet.getName(), pet.getDescription(), pet.getDateOfBirth(), pet.getPrice());
    }
}
