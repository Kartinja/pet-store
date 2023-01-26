package com.dejan.popovski.petshop.rest;

import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.rest.converters.PetConverter;
import com.dejan.popovski.petshop.rest.dto.PetResponseDto;
import com.dejan.popovski.petshop.service.PetService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/pet")
public class PetController {
    private PetService petService;
    private PetConverter petConverter;

    @PostMapping("")
    public List<PetResponseDto> createPets() {
        return petService.createPets().stream().map(petConverter::from).collect(Collectors.toList());
    }

    @GetMapping("")
    public List<PetResponseDto> getAll() {
        return petService.getAll().stream().map(petConverter::from).collect(Collectors.toList());
    }
}
