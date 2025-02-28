package com.facundosaracho.mstransactions.presentation.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;


@Tag(name = "Transactions")
public interface TransactionsApi {
    @Operation(
            operationId = "getLastTransactions",
            summary = "Esta operación sirve para obtener los IDs de aquellas compañias que hayan hecho transacciones " +
                    "filtradas por una fecha. Si no se envía ningún valor como fecha, se toma en cuenta el último mes.")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "OK")})
    @GetMapping("register")
    List<Long> getLastTransactions(LocalDateTime filterDate);
}
