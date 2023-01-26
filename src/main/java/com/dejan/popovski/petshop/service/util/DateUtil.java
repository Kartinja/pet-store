package com.dejan.popovski.petshop.service.util;

import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.Random;

@Service
public class DateUtil {
    private final Random random = new Random();
    public Date randomDate(){
        int daysToSubstruct = random.nextInt(365*10);
        Instant randomDay = Instant.now().minus(daysToSubstruct, ChronoUnit.DAYS);
        return Date.from(randomDay);
    }
}
