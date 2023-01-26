package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.dto.UserResponseDto;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
    public UserResponseDto from(User user) {
        return new UserResponseDto(user.getId(), user.getFirstName(), user.getLastName(), user.getEmail(), user.getBudget(), user.getPets());
    }
}
