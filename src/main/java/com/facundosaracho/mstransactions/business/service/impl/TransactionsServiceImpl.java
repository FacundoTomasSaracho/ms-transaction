package com.facundosaracho.mstransactions.business.service.impl;

import com.facundosaracho.mstransactions.business.service.TransactionsService;
import com.facundosaracho.mstransactions.persistence.entities.TransactionEntity;
import com.facundosaracho.mstransactions.persistence.repository.TransactionsRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionsServiceImpl implements TransactionsService {

    private final TransactionsRepository transactionsRepository;

    @Override
    public List<Long> getLastTransactions(LocalDateTime filterDate) {

        List<Long> companiesIds = transactionsRepository.findCompanyIdByTransactionDateGreaterThanEqual(filterDate);

        if (companiesIds.isEmpty()) log.warn("No transactions were found for filter date: {}", filterDate);

        return companiesIds;
    }

}
