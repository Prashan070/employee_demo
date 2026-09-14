package com.example.employeeDemo.Dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ExceptionResponseDto {
    private LocalDateTime timestamp;
    private int statusCode;
    private String error;
    private String message;
    private String path;

    public ExceptionResponseDto(LocalDateTime timestamp, int statusCode, String error, String message, String path) {
        this.timestamp = timestamp;
        this.statusCode = statusCode;
        this.error = error;
        this.message = message;
        this.path = path;
    }
}
