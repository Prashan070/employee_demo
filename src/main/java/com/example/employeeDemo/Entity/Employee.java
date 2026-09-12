package com.example.employeeDemo.Entity;

import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDateTime;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Length(max = 12)
    private String name;


    private int age;
    private String email;
    private int rollNo;
    private String subject;
    private Boolean deleted;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PostConstruct
    public void setCreateDate() {
     setCreatedAt(LocalDateTime.now());
    }

    @PostConstruct
    public void setUpdateDate() {
    setUpdatedAt(LocalDateTime.now());
    }
}
