package com.dejan.popovski.petshop.service;

import com.dejan.popovski.petshop.repository.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> createUsers();
    List<User> getAll();
    User buy();
}
