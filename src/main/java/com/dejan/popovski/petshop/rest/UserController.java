package com.dejan.popovski.petshop.rest;

import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.converters.UserConverter;
import com.dejan.popovski.petshop.rest.dto.UserResponseDto;
import com.dejan.popovski.petshop.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private UserConverter userConverter;

    @PostMapping("")
    public List<UserResponseDto> createUsers() {
        return userService.createUsers().stream().map(userConverter::from).collect(Collectors.toList());
    }
    @PostMapping("/buy")
    public List<UserResponseDto> buy(){
        return userService.buy().stream().map(userConverter::from).collect(Collectors.toList());
    }

    @GetMapping("")
    public List<UserResponseDto> getAll() {
        return userService.getAll().stream().map(userConverter::from).collect(Collectors.toList());
    }

}
