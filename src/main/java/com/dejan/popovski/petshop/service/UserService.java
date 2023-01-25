package com.dejan.popovski.petshop.service;

import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.dto.UserRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(UserRequestDto userRequestDto);
    List<User> createUsers();
    User get(Long id);
    List<User> getAll();
    User buy();
}
