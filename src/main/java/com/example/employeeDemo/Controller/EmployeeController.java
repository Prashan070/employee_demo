package com.example.employeeDemo.Controller;


import com.example.employeeDemo.Configuration.PaymentGatewayProperties;
import com.example.employeeDemo.Dto.EmployeeRequestDto;
import com.example.employeeDemo.Dto.EmployeeResponseDto;
import com.example.employeeDemo.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {

    EmployeeService employeeService;
    PaymentGatewayProperties paymentGatewayProperties;

    public EmployeeController(EmployeeService employeeService, PaymentGatewayProperties paymentGatewayProperties) {
        this.employeeService = employeeService;
        this.paymentGatewayProperties = paymentGatewayProperties;
    }

    @GetMapping("/myname")
    public String Test() {
        return paymentGatewayProperties.getType() + " " +
                paymentGatewayProperties.getRetryCount()+ " " +
                paymentGatewayProperties.getTimeout();
    }

    @PostMapping
    public ResponseEntity<EmployeeResponseDto> createEmployee(@Valid @RequestBody EmployeeRequestDto employeeRequestDto) {
        EmployeeResponseDto employeeResponseDto = employeeService.createEmployee(employeeRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeResponseDto);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeResponseDto>> getListOfEmployee() {
        List<EmployeeResponseDto> employeeResponseDtos = employeeService.getListOfEmployee();
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable Long id) {
        EmployeeResponseDto employeeResponseDto = employeeService.getEmployeeById(id);
        return ResponseEntity.status(HttpStatus.OK).body(employeeResponseDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PatchMapping("/soft-delete/{id}")
    public ResponseEntity<String> softDeleteEmployeeById(@PathVariable Long id) {
        employeeService.softDeleteEmployeeById(id);
        return ResponseEntity.status(HttpStatus.GONE).build();
    }


}
