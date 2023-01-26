package com.dejan.popovski.petshop.repository;

import com.dejan.popovski.petshop.repository.model.HistoryLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryLogJpaRepository extends JpaRepository<HistoryLog,Long> {
}
