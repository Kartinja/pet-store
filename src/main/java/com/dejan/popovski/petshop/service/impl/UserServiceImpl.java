package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.UserJpaRepository;
import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private UserJpaRepository userJpaRepository;

    @Override
    public List<User> createUsers() {
        Random random = new Random();
        int numberUsers = random.nextInt(10) + 1;
        List<User> users = new LinkedList<>();
        for (int i = 0; i < numberUsers; i++) {
            String firstName = RandomStringUtils.randomAlphabetic(3, 10);
            String lastName = RandomStringUtils.randomAlphabetic(3, 15);
            String email = RandomStringUtils.randomAlphabetic(3, 20) + "@" + RandomStringUtils.randomAlphabetic(3, 7) + ".com";
            int budget = random.nextInt(7,30);

            User user = new User(firstName,lastName,email,budget);
            userJpaRepository.save(user);
            users.add(user);
        }
        return users;
    }
    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll();
    }

    @Override
    public User buy() {
        List<User> users = getAll();
        return null;
    }
}
