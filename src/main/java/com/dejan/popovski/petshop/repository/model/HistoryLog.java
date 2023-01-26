package com.dejan.popovski.petshop.repository.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.springframework.stereotype.Service;

import java.util.Date;

@AllArgsConstructor
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
    private int numberOfUnSuccessBuys;

    public HistoryLog(Date dateOfExecution, int numberOfSuccessBuys, int numberOfUnSuccessBuys) {
        this.dateOfExecution = dateOfExecution;
        this.numberOfSuccessBuys = numberOfSuccessBuys;
        this.numberOfUnSuccessBuys = numberOfUnSuccessBuys;
    }
}