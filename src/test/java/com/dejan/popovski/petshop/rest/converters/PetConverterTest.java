package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.dto.PetResponseDto;
import com.dejan.popovski.petshop.rest.dto.UserResponseDto;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class PetConverterTest {
    @Mock
    private UserConverter userConverter;
    @InjectMocks
    private PetConverter petConverter;

    @Test
    void petConverterWithoutOwner() {
        //given
        Date date = Date.from(LocalDate.of(2010, 4, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Pet pet = new Pet("name", "description", date);
        pet.setId(1L);
        //when
        PetResponseDto petResponseDto = petConverter.from(pet);
        //then
        assertNotNull(petResponseDto);
        assertEquals(1L, petResponseDto.getId());
        assertEquals("name", petResponseDto.getName());
        assertEquals("description", petResponseDto.getDescription());
        assertEquals(12,petResponseDto.getPrice());
        assertEquals(date, petResponseDto.getDateOfBirth());
    }

    @Test
    void petConverterWithOwner() {
        //given
        Date date = Date.from(LocalDate.of(2020, 4, 5).atStartOfDay(ZoneId.systemDefault()).toInstant());
        Pet pet = new Pet("name", "description", date);
        pet.setId(1L);
        ArrayList<Pet> pets = new ArrayList<>();
        pets.add(pet);
        User owner = new User("first", "last", "email", 10);
        owner.setPets(pets);
        pet.setOwner(owner);
        UserResponseDto userResponseDto = new UserResponseDto(1L, "first", "last", "email", 10, pets);
        Mockito.when(userConverter.from(any())).thenReturn(userResponseDto);
        //when
        PetResponseDto petResponseDto = petConverter.from(pet);
        //then
        assertNotNull(petResponseDto);
        assertEquals(1L,petResponseDto.getId());
        assertEquals(2,petResponseDto.getPrice());
        assertEquals("name", petResponseDto.getName());
        assertEquals("description", petResponseDto.getDescription());
        assertEquals(date, petResponseDto.getDateOfBirth());
        assertEquals(userResponseDto, petResponseDto.getOwner());
    }

}