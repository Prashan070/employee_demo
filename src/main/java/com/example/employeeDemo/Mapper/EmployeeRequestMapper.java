package com.example.employeeDemo.Mapper;

import com.example.employeeDemo.Dto.EmployeeRequestDto;
import com.example.employeeDemo.Entity.Employee;

public class EmployeeRequestMapper {


    public static Employee getEmployeeEntity(EmployeeRequestDto employeeRequestDto){
        Employee employee = new Employee();
        employee.setName(employeeRequestDto.getName());
        employee.setAge(employeeRequestDto.getAge());
        employee.setEmail(employeeRequestDto.getEmail());
        employee.setRollNo(employeeRequestDto.getRollNo());
        employee.setSubject(employeeRequestDto.getEmail());
        return employee;
    }
}
