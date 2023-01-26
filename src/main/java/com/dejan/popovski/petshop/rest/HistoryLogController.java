package com.dejan.popovski.petshop.rest;

import com.dejan.popovski.petshop.rest.converters.HistoryLogConverter;
import com.dejan.popovski.petshop.rest.dto.HistoryLogResponseDto;
import com.dejan.popovski.petshop.service.HistoryLogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@RequestMapping("/historyLog")
public class HistoryLogController {
    private HistoryLogService historyLogService;
    private HistoryLogConverter historyLogConverter;

    @GetMapping("")
    public List<HistoryLogResponseDto> getAll() {
        return historyLogService.getAll().stream().map(historyLogConverter::from).collect(Collectors.toList());
    }
}
