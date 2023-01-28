package com.dejan.popovski.petshop.service.impl;

import com.dejan.popovski.petshop.repository.HistoryLogJpaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class HistoryLogServiceImplTest {
    @Mock
    private HistoryLogJpaRepository historyLogJpaRepository;
    @InjectMocks
    private HistoryLogServiceImpl historyLogService;
    @Test
    void testGetAllHistoryLogs() {
        historyLogService.getAll();
        verify(historyLogJpaRepository).findAll();
    }
}