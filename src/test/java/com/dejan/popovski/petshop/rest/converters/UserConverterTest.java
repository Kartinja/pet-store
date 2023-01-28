package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.User;
import com.dejan.popovski.petshop.rest.dto.UserResponseDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class UserConverterTest {
    private UserConverter userConverter = new UserConverter();

    @Test
    void testUserConverter() {
        //given
        User user = new User("firstName", "lastName", "email", 10);
        user.setId(1L);
        //when
        UserResponseDto userResponseDto = userConverter.from(user);
        //then
        assertNotNull(user);
        assertEquals(1L,userResponseDto.getId());
        assertEquals("firstName", userResponseDto.getFirstName());
        assertEquals("lastName", userResponseDto.getLastName());
        assertEquals("email", userResponseDto.getEmail());
        assertEquals(10, userResponseDto.getBudget());
        assertEquals(new ArrayList<>(), userResponseDto.getPets());
    }
}