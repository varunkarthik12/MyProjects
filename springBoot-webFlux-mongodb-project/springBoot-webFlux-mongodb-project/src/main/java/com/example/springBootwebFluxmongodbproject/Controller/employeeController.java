package com.example.springBootwebFluxmongodbproject.Controller;

import com.example.springBootwebFluxmongodbproject.Service.EmployeeService;
import com.example.springBootwebFluxmongodbproject.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class employeeController {

    @Autowired
    private EmployeeService employeeService;
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> create_employee(@RequestBody EmployeeDto employeeDto)
    {
        return employeeService.createEmployee(employeeDto);
    }

    @GetMapping
    public Mono<EmployeeDto> retrieve_employee(@RequestParam String id)
    {
        return employeeService.retrieveEmployee(id);
    }

    @GetMapping("allEmployees")
    public Flux<EmployeeDto> getAllEmployees()
    {
        return employeeService.retrieveAllEmployees();
    }

    @PutMapping
    public Mono<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto)
    {
        String id = employeeDto.getId();

        return employeeService.updateEmployee(employeeDto,id);

    }

    @DeleteMapping
    public Mono<Void> deleteEmployee(@RequestParam String id)
    {
        return employeeService.DeleteEmployee(id);
    }


}
