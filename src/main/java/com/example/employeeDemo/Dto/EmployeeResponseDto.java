package com.example.employeeDemo.Dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class EmployeeResponseDto {

    private Long id;
    private String name;
    private int age;
    private String email;
    private int rollNo;
    private String subject;
    private Boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

}
