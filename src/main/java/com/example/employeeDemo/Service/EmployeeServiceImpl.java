package com.example.employeeDemo.Service;

import com.example.employeeDemo.Configuration.PaymentGatewayProperties;
import com.example.employeeDemo.Dto.EmployeeRequestDto;
import com.example.employeeDemo.Dto.EmployeeResponseDto;
import com.example.employeeDemo.Entity.Employee;
import com.example.employeeDemo.Exception.DuplicateEmailException;
import com.example.employeeDemo.Exception.ResourceNotFoundException;
import com.example.employeeDemo.Mapper.EmployeeRequestMapper;
import com.example.employeeDemo.Mapper.EmployeeResponseMapper;
import com.example.employeeDemo.Respository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestDto employeeRequestDto) {
        Employee employee = EmployeeRequestMapper.getEmployeeEntity(employeeRequestDto);
        employee.setIsDeleted(false);

        boolean isAvailable = employeeRepository.existsByEmail(employee.getEmail());

        if (isAvailable) {
            throw new DuplicateEmailException("Duplicate email found");
        }


        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeResponseMapper.getEmployeeResponse(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDto> getListOfEmployee() {
        List<Employee> employeeLis = employeeRepository.findByIsDeletedFalse();
        return EmployeeResponseMapper.getListEmployeeResponse(employeeLis);
    }

    @Override
    public EmployeeResponseDto getEmployeeById(Long id) {
        Employee employee = employeeRepository.findByIsDeletedFalseAndId(id).orElseThrow(() -> new ResourceNotFoundException("Emp is not avaiable"));
        return EmployeeResponseMapper.getEmployeeResponse(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        employeeRepository.findByIsDeletedFalseAndId(id).orElseThrow(() -> new ResourceNotFoundException("Emp is not avaiable"));
        employeeRepository.deleteById(id);
    }

    @Override
    public void softDeleteEmployeeById(Long id) {
        Employee employee = employeeRepository.findByIsDeletedFalseAndId(id).orElseThrow(() -> new RuntimeException("Not found"));
        employee.setIsDeleted(true);
        employeeRepository.save(employee);

    }

}
