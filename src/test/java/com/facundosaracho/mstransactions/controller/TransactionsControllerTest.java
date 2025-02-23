package com.facundosaracho.mstransactions.controller;

import com.facundosaracho.mstransactions.business.service.TransactionsService;
import com.facundosaracho.mstransactions.presentation.controller.TransactionsController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class TransactionsControllerTest {

    @InjectMocks
    private TransactionsController transactionsController;

    @Mock
    private Logger logger;

    @Mock
    private TransactionsService transactionsService;

    @Test
    void success() {

        List<Long> mockResponse = List.of(1L, 2L, 3L);
        Mockito.when(transactionsService.getLastTransactions(any())).thenReturn(mockResponse);

        final List<Long> companiesIds = transactionsController.getLastTransactions(any(LocalDateTime.class));

        Assertions.assertNotNull(companiesIds);
        assertEquals(1L, companiesIds.get(0).longValue());

    }


}
