package com.dejan.popovski.petshop.repository.model;

import java.util.Date;

public interface Pet {

    User getOwner();

    void setOwner(User owner);

    String getName();

    void setName(String name);

    String getDescription();

    void setDescription(String description);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    int getPrice();

    void setPrice(int price);
}
