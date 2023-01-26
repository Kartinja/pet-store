package com.dejan.popovski.petshop.rest.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@AllArgsConstructor
@Setter
@Getter
public class HistoryLogResponseDto {
    private Long id;
    @NotNull
    private Date dateOfExecution;
    @NotNull
    private int numberOfSuccessBuys;
    @NotNull
    private int numberOfUnSuccessBuys;
}
