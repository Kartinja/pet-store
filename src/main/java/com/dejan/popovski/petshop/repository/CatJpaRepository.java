package com.dejan.popovski.petshop.repository;

import com.dejan.popovski.petshop.repository.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatJpaRepository extends JpaRepository<Cat, Long> {
}
