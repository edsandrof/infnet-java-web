package com.github.edsandrof.infnetjavaweb.model.service;

import com.github.edsandrof.infnetjavaweb.application.exceptions.EmployeeNotFoundException;
import com.github.edsandrof.infnetjavaweb.infrastructure.repository.EmployeeRepository;
import com.github.edsandrof.infnetjavaweb.model.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee find(Long id) {
        return employeeRepository.findById(id).orElseThrow(
                () -> new EmployeeNotFoundException("Vehicle dealer employee " + id + " was not found"));
    }

    public List<Employee> listAll() {
        return employeeRepository.findAll();
    }

    public Employee register(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> registerAll(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    public void delete(Long id) {
        Employee employee = find(id);
        employeeRepository.delete(employee);
    }
}
