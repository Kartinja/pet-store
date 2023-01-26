package com.dejan.popovski.petshop.service;

import com.dejan.popovski.petshop.repository.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {
    List<User> createUsers();
    List<User> getAll();
    List<User> buy();
}
