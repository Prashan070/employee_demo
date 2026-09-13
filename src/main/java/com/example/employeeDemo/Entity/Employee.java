package com.example.employeeDemo.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 12)
    private String name;
    @Column(nullable = false)
    private Integer age;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer rollNo;
    @Column(nullable = false)
    private String subject;
    @Column(nullable = false)
    private Boolean isDeleted;

    @Column(nullable = false)
    private LocalDateTime createdAt;
    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @PrePersist
    public void onCreate() {
        setCreatedAt(LocalDateTime.now());
        setUpdatedAt(LocalDateTime.now());
    }

    @PreUpdate
    public void onUpdate() {
        setUpdatedAt(LocalDateTime.now());
    }
}
