package com.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.entity.Employee;
import com.repository.EmployeeRepository;

import java.util.Optional;

public class AuthenticationServiceImplementation implements AuthenticationService {

    EmployeeRepository employeeRepository;

    public AuthenticationServiceImplementation(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public boolean authenticate(String username, String password) {
        Optional<Employee> employee = employeeRepository.findByEmpUsername(username);
        if (employee.isEmpty()) {
            return false;
        }
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(), employee.get().getPassword());
        if (result.verified) {
            return true;
        }
        return false;
    }

}
