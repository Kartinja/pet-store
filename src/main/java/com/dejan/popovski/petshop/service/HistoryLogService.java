package com.dejan.popovski.petshop.service;

import com.dejan.popovski.petshop.repository.model.HistoryLog;
import org.springframework.stereotype.Service;

import java.util.List;


public interface HistoryLogService {
    List<HistoryLog> getAll();
}
