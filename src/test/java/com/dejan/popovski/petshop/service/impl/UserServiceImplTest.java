package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.HistoryLogJpaRepository;
import com.dejan.popovski.petshop.repository.PetJpaRepository;
import com.dejan.popovski.petshop.repository.UserJpaRepository;
import com.dejan.popovski.petshop.repository.model.Cat;
import com.dejan.popovski.petshop.repository.model.Dog;
import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.repository.model.User;
import jakarta.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserJpaRepository userJpaRepository;
    @Mock
    private PetJpaRepository petJpaRepository;
    @Mock
    private HistoryLogJpaRepository historyLogJpaRepository;
    @InjectMocks
    private UserServiceImpl userService;

    @Test
    void testGetAllUsers() {
        userService.getAll();
        verify(userJpaRepository).findAll();
    }

    @Test
    void shouldNotBuyPetsWhenNoPetsAndNoUsersInDB() {
        //given
        when(petJpaRepository.findAllByOwnerIsNullOrderByPriceDesc()).thenReturn(new ArrayList<>());
        when(userJpaRepository.findAllByOrderByBudgetDesc()).thenReturn(new ArrayList<>());
        //when
        List<User> users = userService.buy();
        //then
        Assertions.assertEquals(users.size(), 0);
    }

    @Test
    void shouldNotBuyPetsWhenNoPetsInDB() {
        //given
        when(petJpaRepository.findAllByOwnerIsNullOrderByPriceDesc()).thenReturn(new ArrayList<>());
        List<User> users = List.of(
                new User("User1", "last1", "email1", 10),
                new User("User2", "last2", "email1", 5),
                new User("User2", "last2", "email1", 2));
        when(userJpaRepository.findAllByOrderByBudgetDesc()).thenReturn(users);
        //when
        List<User> result = userService.buy();
        //then
        Assertions.assertEquals(0, result.size());
        verify(historyLogJpaRepository).save(any());
    }

    @Test
    void shouldBuyPets() {
        //given
        List<Pet> pets = new ArrayList<>();

        Date date1 = Date.from(LocalDate.of(2010, 4, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date2 = Date.from(LocalDate.of(2021, 4, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date date3 = Date.from(LocalDate.of(2022, 4, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        pets.add(new Dog("dog1", "description", date1, 1));
        pets.add(new Cat("cat1", "description", date2));
        pets.add(new Cat("cat2", "description", date3));
        when(petJpaRepository.findAllByOwnerIsNullOrderByPriceDesc()).thenReturn(pets);

        List<User> users = List.of(
                new User("User1", "last1", "email1", 10),
                new User("User2", "last2", "email1", 5),
                new User("User2", "last2", "email1", 2));
        when(userJpaRepository.findAllByOrderByBudgetDesc()).thenReturn(users);
        //when
        List<User> result = userService.buy();
        //then
        Assertions.assertEquals(2, result.size());
        verify(historyLogJpaRepository).save(any());
    }

    @Test
    void testCreateUsers() {
        //given
        when(userJpaRepository.save(any())).thenReturn(new User("User1", "last1", "email1", 10));
        //when
        List<User> users = userService.createUsers();
        //then
        Assertions.assertTrue(users.size() > 0);
        Assertions.assertTrue(users.size() <= 10);
    }

}