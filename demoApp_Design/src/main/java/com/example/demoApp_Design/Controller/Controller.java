package com.example.demoApp_Design.Controller;

import com.example.demoApp_Design.Dto.EmployeeDto;
import com.example.demoApp_Design.Entity.Employee;
import com.example.demoApp_Design.Service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
@RequestMapping("api/employee")
public class Controller {

    @Autowired
    private EmployeeService empl_serv;

    @Autowired
    private ModelMapper mod_map;

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployee()
    {
        return new ResponseEntity<>(empl_serv.getAllEmployeeDetails(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> CreateEmployee(@RequestBody EmployeeDto emp) throws Exception {
        EmployeeDto empdto = empl_serv.createEmployee(emp);
        return new ResponseEntity<>(empdto,HttpStatus.CREATED);
    }



}
