package com.facundosaracho.mstransactions.persistence.repository;

import com.facundosaracho.mstransactions.persistence.entities.TransactionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsRepository extends JpaRepository<TransactionEntity, Long> {

    List<Long> findCompanyIdByTransactionDateGreaterThanEqual(LocalDateTime transactionDate);
}
