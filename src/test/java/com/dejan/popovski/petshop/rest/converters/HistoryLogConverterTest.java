package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.HistoryLog;
import com.dejan.popovski.petshop.rest.dto.HistoryLogResponseDto;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;


class HistoryLogConverterTest {
    private HistoryLogConverter historyLogConverter = new HistoryLogConverter();

    @Test
    void shouldConvertAllFields() {
        //given
        Date date = Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant());
        HistoryLog historyLog = new HistoryLog(date, 2, 3);
        historyLog.setId(10L);
        //when
        HistoryLogResponseDto from = historyLogConverter.from(historyLog);
        //then
        assertNotNull(from);
        assertEquals(from.getId(),10L);
        assertEquals(from.getDateOfExecution(),date);
        assertEquals(from.getNumberOfSuccessBuys(),2);
        assertEquals(from.getNumberOfUnSuccessfulBuys(),3);

    }
}