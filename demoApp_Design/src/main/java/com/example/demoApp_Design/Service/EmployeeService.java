package com.example.demoApp_Design.Service;

import com.example.demoApp_Design.Dto.EmployeeDto;
import com.example.demoApp_Design.Entity.Employee;
import com.example.demoApp_Design.Repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeDto> getAllEmployeeDetails();

    public EmployeeDto createEmployee( EmployeeDto employee) throws Exception;

}
