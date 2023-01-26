package com.dejan.popovski.petshop.repository;

import com.dejan.popovski.petshop.repository.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetJpaRepository extends JpaRepository<Pet,Long> {
}
