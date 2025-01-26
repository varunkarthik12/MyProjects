package com.example.springBootwebFluxmongodbproject.Service;

import com.example.springBootwebFluxmongodbproject.dto.EmployeeDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EmployeeService {

    Mono<EmployeeDto> createEmployee(EmployeeDto employeeDto);

    Mono <EmployeeDto> retrieveEmployee(String id);

    Flux<EmployeeDto> retrieveAllEmployees();

    Mono<EmployeeDto> updateEmployee(EmployeeDto employeeDto,String id);

    Mono<Void> DeleteEmployee(String id);


}
