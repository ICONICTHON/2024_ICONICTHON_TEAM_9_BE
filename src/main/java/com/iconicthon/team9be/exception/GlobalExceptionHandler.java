package com.iconicthon.team9be.exception;

import com.iconicthon.team9be.util.BadRequestErrorResponse;
import com.iconicthon.team9be.util.ErrorDetail;
import com.iconicthon.team9be.util.ErrorResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    @ApiResponse(
            responseCode = "404",
            description = "Resource not found",
            content =
            @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ErrorResponse.class)))
    public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException ex) {
        String details =
                String.format(
                        "Resource Type: %s, Resource ID: %s", ex.getResourceType(), ex.getResourceId());
        ErrorDetail errorDetail = new ErrorDetail("RESOURCE_NOT_FOUND", ex.getMessage(), details);
        ErrorResponse response =
                new ErrorResponse("Resource not found.", Collections.singletonList(errorDetail));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ApiResponse(
            responseCode = "400",
            description = "Invalid argument",
            content =
            @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BadRequestErrorResponse.class)))
    public ResponseEntity<BadRequestErrorResponse> handleIllegalArgumentException(
            IllegalArgumentException ex) {
        ErrorDetail errorDetail =
                new ErrorDetail(
                        "INVALID_ARGUMENT", ex.getMessage(), "Ensure all required arguments are provided.");
        BadRequestErrorResponse response =
                new BadRequestErrorResponse(
                        "Invalid argument provided.", Collections.singletonList(errorDetail));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadRequestException.class)
    @ApiResponse(
            responseCode = "400",
            description = "Bad Request",
            content =
            @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BadRequestErrorResponse.class)))
    public ResponseEntity<BadRequestErrorResponse> handleBadRequestException(BadRequestException ex) {
        BadRequestErrorResponse response =
                new BadRequestErrorResponse("Bad request error.", ex.getErrors());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}
