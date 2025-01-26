package com.example.springBootwebFluxmongodbproject.Repository;

import com.example.springBootwebFluxmongodbproject.Entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee,String> {
}
