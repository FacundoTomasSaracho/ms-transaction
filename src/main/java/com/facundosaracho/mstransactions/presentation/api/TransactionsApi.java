package com.facundosaracho.mstransactions.presentation.api;

import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsApi {

    @GetMapping()
    List<Long> getLastTransactions(LocalDateTime filterDate);
}
