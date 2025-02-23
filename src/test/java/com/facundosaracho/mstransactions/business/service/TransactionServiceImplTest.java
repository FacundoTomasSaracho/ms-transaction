package com.facundosaracho.mstransactions.business.service;

import com.facundosaracho.mstransactions.business.service.impl.TransactionsServiceImpl;
import com.facundosaracho.mstransactions.persistence.entities.TransactionEntity;
import com.facundosaracho.mstransactions.persistence.repository.TransactionsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(OutputCaptureExtension.class)
class TransactionServiceImplTest {


    @InjectMocks
    private TransactionsServiceImpl transactionsService;

    @Mock
    private Logger logger;

    @Mock
    private TransactionsRepository transactionsRepository;


    @Test
    void success() {

        List<TransactionEntity> mockResponse = mockTransactionsEntity();
        MockitoAnnotations.openMocks(this);
        LocalDateTime filterDate = LocalDateTime.now();

        when(transactionsRepository.findByTransactionDateGreaterThanEqual(any(LocalDateTime.class))).thenReturn(mockResponse);

        List<Long> companiesIds = transactionsService.getLastTransactions(filterDate);

        Assertions.assertNotNull(companiesIds);
        Assertions.assertEquals(1L, companiesIds.get(0).longValue());


    }

    private List<TransactionEntity> mockTransactionsEntity() {
        TransactionEntity tr1 = new TransactionEntity();
        TransactionEntity tr2 = new TransactionEntity();
        tr1.setCompanyId(1L);
        tr1.setAmount(BigDecimal.valueOf(111.11));

        tr2.setCompanyId(2L);
        tr2.setAmount(BigDecimal.valueOf(111.1111));

        return List.of(tr1, tr2);
    }

}
