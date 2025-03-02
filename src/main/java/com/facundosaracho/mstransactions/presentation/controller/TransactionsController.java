package com.facundosaracho.mstransactions.presentation.controller;

import com.facundosaracho.mstransactions.business.service.TransactionsService;
import com.facundosaracho.mstransactions.presentation.api.TransactionsApi;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
public class TransactionsController implements TransactionsApi {

    private final TransactionsService transactionsService;

    @Override
    @GetMapping("companies/last-transactions")
    public List<Long> getLastTransactions(@RequestParam(value = "filter_date") LocalDateTime filterDate) {
        log.info("Starting to get last companies that made transactions filtered by date. FilterDate: {}", filterDate);
        List<Long> companiesIds = transactionsService.getLastTransactions(filterDate)
                .stream()
                .toList();
        log.info("End of method. Companies were found successfully. Returning its ids.");
        return companiesIds;
    }
}
