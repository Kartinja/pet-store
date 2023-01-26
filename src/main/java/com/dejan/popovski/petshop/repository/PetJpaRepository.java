package com.dejan.popovski.petshop.repository;

import com.dejan.popovski.petshop.repository.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PetJpaRepository extends JpaRepository<Pet,Long> {
    List<Pet> findAllByOrderByPriceDesc();
    List<Pet> findAllByOwnerIsNullOrderByPriceDesc();
}
