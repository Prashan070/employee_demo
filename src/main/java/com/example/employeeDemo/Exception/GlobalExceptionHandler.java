package com.example.employeeDemo.Exception;

import com.example.employeeDemo.Dto.ExceptionResponseDto;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ExceptionResponseDto> handleResourceNotFoundException(HttpServletRequest httpRequest,
                                                                                ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                new ExceptionResponseDto(
                        LocalDateTime.now(),
                        404,
                        HttpStatus.NOT_FOUND.toString(),
                        ex.getMessage(),
                        httpRequest.getRequestURI()
                ));
    }


    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ExceptionResponseDto> handleDuplicateEmailException(HttpServletRequest httpRequest, DuplicateEmailException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
                new ExceptionResponseDto(
                        LocalDateTime.now(),
                        409,
                        HttpStatus.NOT_FOUND.toString(),
                        ex.getMessage(),
                        httpRequest.getRequestURL().toString()
                ));
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponseDto> handleValidationException(
            MethodArgumentNotValidException ex, HttpServletRequest httpRequest) {

        String errorMessage = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(
                new ExceptionResponseDto(
                        LocalDateTime.now(),
                        400,
                        HttpStatus.BAD_REQUEST.toString(),
                        errorMessage,
                        httpRequest.getRequestURI()
                ));
    }
}
