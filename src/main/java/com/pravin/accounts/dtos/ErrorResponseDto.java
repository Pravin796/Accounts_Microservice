package com.pravin.accounts.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response information"
)
public class ErrorResponseDto {

    @Schema(
            description = "API path invoked by the client", example = "/api/create"
    )
    private String apiPath;

    @Schema(
            description = "Error code representing the error happened", example = "BAD_REQUEST"
    )
    private HttpStatus errorCode;

    @Schema(
            description = "Error message representing the error happened", example = "Validation failed"
    )
    private String errorMessage;

    @Schema(
            description = "Time representing when the error happened", example = "2026-07-10T22:45:00"
    )
    private LocalDateTime errorTime;
}
