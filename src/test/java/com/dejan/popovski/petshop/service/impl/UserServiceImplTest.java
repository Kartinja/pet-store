package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.HistoryLogJpaRepository;
import com.dejan.popovski.petshop.repository.PetJpaRepository;
import com.dejan.popovski.petshop.repository.UserJpaRepository;
import com.dejan.popovski.petshop.repository.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

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
    void getAllUsers(){
        userService.getAll();
        verify(userJpaRepository).findAll();
    }
    @Test
    void shouldNotBuyPetsWhenNoPetsAndNoUsersInDB(){
        //given
        when(petJpaRepository.findAllByOwnerIsNullOrderByPriceDesc()).thenReturn(new ArrayList<>());
        when(userJpaRepository.findAllByOrderByBudgetDesc()).thenReturn(new ArrayList<>());
        //when
        List<User> users = userService.buy();
        //then
        Assertions.assertEquals(users.size(),0);
    }
    @Test
    void shouldNotBuyPetsWhenNoPetsInDB(){
        //given
        when(petJpaRepository.findAllByOwnerIsNullOrderByPriceDesc()).thenReturn(new ArrayList<>());
//        List<User>
        when(userJpaRepository.findAllByOrderByBudgetDesc()).thenReturn(new ArrayList<>());
        //when
        List<User> users = userService.buy();
        //then
        Assertions.assertEquals(users.size(),0);
    }

}