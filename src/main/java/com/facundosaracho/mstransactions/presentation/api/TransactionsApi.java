package com.facundosaracho.mstransactions.presentation.api;

import com.facundosaracho.mstransactions.presentation.exception.ErrorDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.hibernate.annotations.Array;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;


@Tag(name = "Transactions")
public interface TransactionsApi {
    @Operation(
            operationId = "getLastTransactions",
            summary = "Esta operación sirve para obtener los IDs de aquellas compañias que hayan hecho transacciones " +
                    "filtradas por una fecha. Si no se envía ningún valor como fecha, se toma en cuenta el último mes.",
    responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "OK",
                            content = @Content(
                                    mediaType = "application/json",
                                    array = @ArraySchema(schema = @Schema(implementation = Long.class))
                            )
                    ),
            @ApiResponse(
                    responseCode = "500",
                    description = "OK",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(
                                    type = "ErrorDto",
                                    implementation = ErrorDto.class
                            )
                    )
            )
    })
    @GetMapping("register")
    List<Long> getLastTransactions(LocalDateTime filterDate);
}
