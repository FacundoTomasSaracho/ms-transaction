package com.facundosaracho.mstransactions.presentation.controller;

import com.facundosaracho.mstransactions.business.service.TransactionsService;
import com.facundosaracho.mstransactions.presentation.api.TransactionsApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("transactions")
@RequiredArgsConstructor
public class TransactionsController implements TransactionsApi {

    private final TransactionsService transactionsService;

    @Override
    @GetMapping()
    public List<Long> getLastTransactions(@RequestParam(value = "filter_date", required = false) LocalDateTime filterDate) {
        log.info("<<< Starting to get las transactions filtered by date and getting companyId >>>>>");
        List<Long> companiesIds = transactionsService.getLastTransactions(filterDate)
                .stream()
                .toList();
        log.info("<<<< End of method. Companies were found successfully. >>>>>");
        return companiesIds;
    }
}
