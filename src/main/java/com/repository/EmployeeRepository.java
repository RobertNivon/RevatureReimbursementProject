package com.repository;

import com.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> findByEmpUsername(String empUsername);
    Optional<Employee> findByEmpId(int empId);
    List<Employee> findAllEmployees();
    void updateByEmpId(Optional<Employee> employee);

    void saveEmployee(Employee employee);
}
