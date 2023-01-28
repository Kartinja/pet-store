package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.CatJpaRepository;
import com.dejan.popovski.petshop.repository.DogJpaRepository;
import com.dejan.popovski.petshop.repository.PetJpaRepository;
import com.dejan.popovski.petshop.repository.model.Cat;
import com.dejan.popovski.petshop.repository.model.Dog;
import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.service.util.DateUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PetServiceImplTest {
    @Mock
    private PetJpaRepository petJpaRepository;
    @Mock
    private DogJpaRepository dogJpaRepository;
    @Mock
    private CatJpaRepository catJpaRepository;
    @Mock
    private DateUtil dateUtil;
    @InjectMocks
    private PetServiceImpl petService;

    @Test
    void testGetAllPets() {
        petService.getAll();
        verify(petJpaRepository.findAll());
    }

    @Test
    public void testCreatePets() {
        // given
        when(dogJpaRepository.save(any())).thenReturn(new Dog("dog1", "description", new Date(), 1));
        when(catJpaRepository.save(any())).thenReturn(new Cat("cat2", "description", new Date()));
        when(dateUtil.randomDate()).thenReturn(new Date());
        // when
        List<Pet> pets = petService.createPets();
        // then
        assertTrue(pets.size() > 0);
    }
}