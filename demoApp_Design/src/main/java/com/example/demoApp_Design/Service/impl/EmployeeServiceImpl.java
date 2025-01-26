package com.example.demoApp_Design.Service.impl;

import com.example.demoApp_Design.Dto.EmployeeDto;
import com.example.demoApp_Design.Entity.Employee;
import com.example.demoApp_Design.Repository.EmployeeRepository;
import com.example.demoApp_Design.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository emp_rep;

    @Autowired
    private ModelMapper mod_map;

    @Override
    public List<EmployeeDto> getAllEmployeeDetails() {

        return emp_rep.findAll().stream().map((emp)-> mod_map.map(emp, EmployeeDto.class)).collect(Collectors.toList());
    }

    @Override
    public EmployeeDto createEmployee(EmployeeDto employee) throws Exception {

        Employee e1 = mod_map.map(employee,Employee.class);
        Employee saved_emp = emp_rep.save(e1);
        EmployeeDto empDto =  mod_map.map(saved_emp,EmployeeDto.class);

        return empDto;
    }


}
