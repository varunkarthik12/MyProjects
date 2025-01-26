package com.example.springBootwebFluxmongodbproject.Service.impl;

import com.example.springBootwebFluxmongodbproject.Entity.Employee;
import com.example.springBootwebFluxmongodbproject.Repository.EmployeeRepository;
import com.example.springBootwebFluxmongodbproject.Service.EmployeeService;
import com.example.springBootwebFluxmongodbproject.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class employeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper mod_map;


    @Override
    public Mono<EmployeeDto> createEmployee(EmployeeDto employeeDto) {

        Employee toSave_employee = mod_map.map(employeeDto, Employee.class);

        Mono<Employee> savedEmployee = employeeRepository.save(toSave_employee);

        return savedEmployee.map((saved) -> mod_map.map(saved, EmployeeDto.class));
    }

    @Override
    public Mono<EmployeeDto> retrieveEmployee(String id) {

        Mono<Employee> get_employee  = employeeRepository.findById(id);

        return get_employee.map((got_employee)->mod_map.map(got_employee,EmployeeDto.class));
    }

    @Override
    public Flux<EmployeeDto> retrieveAllEmployees() {

        Flux<Employee> all_employees = employeeRepository.findAll();

        return all_employees.map((emp_dto) -> mod_map.map(emp_dto, EmployeeDto.class));
    }

    @Override
    public Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto,String id) {
        Mono<Employee> e1 = employeeRepository.findById(id);

        Mono<Employee> u1 = e1.flatMap((e)->{
            e.setFirstName(employeeDto.getFirstName());
            e.setLastName(employeeDto.getLastName());
            e.setEmail(employeeDto.getEmail());

            return employeeRepository.save(e);
        });

        return u1.map((up)-> mod_map.map(up, EmployeeDto.class));
    }

    @Override
    public Mono<Void> DeleteEmployee(String id) {
       return employeeRepository.deleteById(id);

    }


}
