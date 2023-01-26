package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.HistoryLogJpaRepository;
import com.dejan.popovski.petshop.repository.model.HistoryLog;
import com.dejan.popovski.petshop.service.HistoryLogService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class HistoryLogServiceImpl implements HistoryLogService {
    private HistoryLogJpaRepository historyLogJpaRepository;
    @Override
    public List<HistoryLog> getAll() {
        return historyLogJpaRepository.findAll();
    }
}
