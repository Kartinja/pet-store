package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.Date;

@NoArgsConstructor
@Entity
@Table
@Getter
@Setter
public class HistoryLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private Date dateOfExecution;
    @NotNull
    private int numberOfSuccessBuys;
    @NotNull
    private int numberOfUnSuccessfulBuys;

    public HistoryLog(Date dateOfExecution, int numberOfSuccessBuys, int numberOfUnSuccessfulBuys) {
        this.dateOfExecution = dateOfExecution;
        this.numberOfSuccessBuys = numberOfSuccessBuys;
        this.numberOfUnSuccessfulBuys = numberOfUnSuccessfulBuys;
    }
}
