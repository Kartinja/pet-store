package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.CatJpaRepository;
import com.dejan.popovski.petshop.repository.DogJpaRepository;
import com.dejan.popovski.petshop.repository.PetJpaRepository;
import com.dejan.popovski.petshop.repository.model.Cat;
import com.dejan.popovski.petshop.repository.model.Dog;
import com.dejan.popovski.petshop.repository.model.Pet;
import com.dejan.popovski.petshop.service.PetService;
import com.dejan.popovski.petshop.service.util.DateUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

@AllArgsConstructor
@Service
public class PetServiceImpl implements PetService {
    private PetJpaRepository petJpaRepository;
    private DogJpaRepository dogJpaRepository;
    private CatJpaRepository catJpaRepository;
    private DateUtil dateUtil;

    /**
     * This method creates and returns pets with random properties.
     * I made an assumption based on the CLI requirement that the create pet method should generate the number of pets randomly.
     * Elements returned are stored in db.
     *
     * @return pets
     */
    @Override
    public List<Pet> createPets() {
        Random random = new Random();
        int numberPets = random.nextInt(10) + 1;
        List<Pet> pets = new LinkedList<>();

        for (int i = 0; i < numberPets; i++) {
            String name = RandomStringUtils.randomAlphabetic(3, 10);
            String description = RandomStringUtils.randomAlphabetic(3, 50);
            Date dateOfBirth = dateUtil.randomDate();
            // I decide randomly on the creation of the pet to get diversity
            if (random.nextBoolean()) {
                int rating = random.nextInt(1, 11);

                Dog pet = new Dog(name, description, dateOfBirth, rating);
                pet = dogJpaRepository.save(pet);
                pets.add(pet);
            } else {
                Cat pet = new Cat(name, description, dateOfBirth);
                pet = catJpaRepository.save(pet);
                pets.add(pet);
            }
        }
        return pets;
    }

    @Override
    public List<Pet> getAll() {
        return petJpaRepository.findAll();
    }
}
