package com.facundosaracho.mstransactions.business.service;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionsService {

    List<Long> getLastTransactions(LocalDateTime filterDate);
}
