package com.dejan.popovski.petshop.rest;

import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.converters.UserConverter;
import com.dejan.popovski.petshop.rest.dto.UserResponseDto;
import com.dejan.popovski.petshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserConverter userConverter;

    @PostMapping("")
    public List<UserResponseDto> createUsers(){
        List<User> users = userService.createUsers();
        List<UserResponseDto> userResponseDtos = new LinkedList<>();
        for (User user: users) {
            userResponseDtos.add(userConverter.from(user));
        }
        return userResponseDtos;
    }

}
