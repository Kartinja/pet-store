package com.dejan.popovski.petshop.repository;

import com.dejan.popovski.petshop.repository.model.Dog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DogJpaRepository extends JpaRepository<Dog,Long> {
}
