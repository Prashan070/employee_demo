package com.example.employeeDemo.Service;

import com.example.employeeDemo.Dto.EmployeeRequestDto;
import com.example.employeeDemo.Dto.EmployeeResponseDto;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface EmployeeService {

    EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto);


    List<EmployeeResponseDto> getListOfEmployee();

    EmployeeResponseDto getEmployeeById(Long id);

    void deleteEmployeeById(Long id);

    void softDeleteEmployeeById(Long id);
}
