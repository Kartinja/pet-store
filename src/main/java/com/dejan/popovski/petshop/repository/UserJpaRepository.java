package com.dejan.popovski.petshop.repository;

import com.dejan.popovski.petshop.repository.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpaRepository extends JpaRepository<User,Long> {
}
