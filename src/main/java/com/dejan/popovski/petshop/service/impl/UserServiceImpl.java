package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.UserJpaRepository;
import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.dto.UserRequestDto;
import com.dejan.popovski.petshop.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    UserJpaRepository userJpaRepository;

    @Override
    public User create(UserRequestDto userRequestDto) {
        User user = new User();
        user.setFirstName(userRequestDto.getFirstName());
        user.setLastName(userRequestDto.getLastName());
        user.setBudget(userRequestDto.getBudget());
        user.setEmail(userRequestDto.getEmail());
        return userJpaRepository.save(user);
    }

    @Override
    public List<User> createUsers() {
        Random random = new Random();
        int numberUsers = random.nextInt(10) + 1;
        List<User> users = new LinkedList<>();
        for (int i = 0; i < numberUsers; i++) {
            String firstName = RandomStringUtils.randomAlphabetic(3, 10);
            String lastName = RandomStringUtils.randomAlphabetic(3, 15);
            String email = RandomStringUtils.randomAlphabetic(3, 20) + "@" + RandomStringUtils.randomAlphabetic(3, 7) + ".com";
            int budget = random.nextInt(10) + 1;
            User user = new User(firstName,lastName,email,budget);
            users.add(create(userRequestDto));
        }
        return users;
    }

    @Override
    public User get(Long id) {
        return userJpaRepository.getReferenceById(id);
    }

    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public User buy() {
        return null;
    }
}
