package com.dejan.popovski.petshop.rest.converters;

import com.dejan.popovski.petshop.repository.model.HistoryLog;
import com.dejan.popovski.petshop.rest.dto.HistoryLogResponseDto;
import org.springframework.stereotype.Service;

@Service
public class HistoryLogConverter {
    public HistoryLogResponseDto from(HistoryLog historyLog) {
        return new HistoryLogResponseDto(historyLog.getId(), historyLog.getDateOfExecution(), historyLog.getNumberOfSuccessBuys(), historyLog.getNumberOfUsersThatDidntBuyPet());
    }
}
