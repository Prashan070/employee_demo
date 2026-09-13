package com.example.employeeDemo.Respository;

import com.example.employeeDemo.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

   List<Employee> findByIsDeletedFalse();

   Optional<Employee> findByIsDeletedFalseAndId(Long id);


}
