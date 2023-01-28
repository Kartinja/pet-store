package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.HistoryLogJpaRepository;
import com.dejan.popovski.petshop.repository.PetJpaRepository;
import com.dejan.popovski.petshop.repository.UserJpaRepository;
import com.dejan.popovski.petshop.repository.model.*;
import com.dejan.popovski.petshop.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.*;

@AllArgsConstructor
@Service
@Slf4j
public class UserServiceImpl implements UserService {
    private UserJpaRepository userJpaRepository;
    private PetJpaRepository petJpaRepository;
    private HistoryLogJpaRepository historyLogJpaRepository;

    /**
     * This method creates users with random properties.
     * Elements created are stored in db.
     *
     * @return users
     */
    @Override
    public List<User> createUsers() {
        Random random = new Random();
        int numberUsers = random.nextInt(10) + 1;
        List<User> users = new LinkedList<>();
        for (int i = 0; i < numberUsers; i++) {
            String firstName = RandomStringUtils.randomAlphabetic(3, 10);
            String lastName = RandomStringUtils.randomAlphabetic(3, 15);
            String email = RandomStringUtils.randomAlphabetic(3, 20) + "@" + RandomStringUtils.randomAlphabetic(3, 7) + ".com";
            int budget = random.nextInt(7, 30);

            User user = new User(firstName, lastName, email, budget);
            userJpaRepository.save(user);
            users.add(user);
        }
        return users;
    }

    @Override
    public List<User> getAll() {
        return userJpaRepository.findAll();
    }

    /**
     * This method tries to buy a pet for every owner.
     *
     * @return users
     */
    @Override
    public List<User> buy() {
        List<User> users = userJpaRepository.findAllByOrderByBudgetDesc();
        List<Pet> petsWithoutOwners = petJpaRepository.findAllByOwnerIsNullOrderByPriceDesc();
        List<User> userBuyers = new LinkedList<>();
        int numberOfPetsBought = 0;

        //im trying to buy a pet for every user
        for (User user : users) {
            for (Pet pet : petsWithoutOwners) {
                if (user.getBudget() >= pet.getPrice()) {
                    List<Pet> ownedPets = new ArrayList<>();
                    if (user.getPets() != null) {
                        ownedPets = user.getPets();
                    }
                    ownedPets.add(pet);
                    user.setPets(ownedPets);
                    user.setBudget(user.getBudget() - pet.getPrice());
                    userJpaRepository.save(user);

                    pet.setOwner(user);
                    petJpaRepository.save(pet);

                    if (pet instanceof Cat) {
                        log.info("Meow, cat {} has owner {}", pet.getName(), user.getFirstName());
                    } else if (pet instanceof Dog) {
                        log.info("Woof, dog {} has owner {}", pet.getName(), user.getFirstName());
                    }
                    numberOfPetsBought++;
                    petsWithoutOwners.remove(pet);
                    userBuyers.add(user);
                    // go to next user, I am giving all users a chance to buy a pet
                    break;
                }
            }
        }
        Date today = Date.from(Instant.now());
        int numberOfUsersThatDidntBuyPet = users.size() - numberOfPetsBought;
        HistoryLog historyLog = new HistoryLog(today, numberOfPetsBought, numberOfUsersThatDidntBuyPet);
        historyLogJpaRepository.save(historyLog);

        return userBuyers;
    }


}
