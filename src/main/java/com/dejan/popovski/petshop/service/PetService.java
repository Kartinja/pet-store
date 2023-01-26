package com.dejan.popovski.petshop.service;

import com.dejan.popovski.petshop.repository.model.Pet;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PetService {
    List<Pet> createPets();
    List<Pet> getAll();
}
