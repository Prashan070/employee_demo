package com.example.employeeDemo.Mapper;

import com.example.employeeDemo.Dto.EmployeeResponseDto;
import com.example.employeeDemo.Entity.Employee;

import java.util.List;

public class EmployeeResponseMapper {

    public static EmployeeResponseDto getEmployeeResponse(Employee employee) {

        EmployeeResponseDto responseDto = new EmployeeResponseDto();

        responseDto.setId(employee.getId());
        responseDto.setName(employee.getName());
        responseDto.setAge(employee.getAge());
        responseDto.setEmail(employee.getEmail());
        responseDto.setRollNo(employee.getRollNo());
        responseDto.setSubject(employee.getSubject());
        responseDto.setDeleted(employee.getDeleted());
        responseDto.setCreatedAt(employee.getCreatedAt());
        responseDto.setUpdatedAt(employee.getUpdatedAt());

        return responseDto;
    }


    public static List<EmployeeResponseDto> getListEmployeeResponse(List<Employee> employeeList){
        return employeeList
                .stream()
                .map()
    }
}

