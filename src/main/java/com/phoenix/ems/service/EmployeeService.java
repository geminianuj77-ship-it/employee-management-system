package com.phoenix.ems.service;

import com.phoenix.ems.entity.Employee;
import com.phoenix.ems.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
         public Employee getEmployeeById(Long id) {
               return employeeRepository.findById(id)
                 .orElseThrow(() -> new RuntimeException("Employee not found"));
}
    public Employee updateEmployee(Long id, Employee employee) {

    Employee existingEmployee = employeeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Employee not found"));

    existingEmployee.setFirstName(employee.getFirstName());
    existingEmployee.setLastName(employee.getLastName());
    existingEmployee.setEmail(employee.getEmail());
    existingEmployee.setSalary(employee.getSalary());

    return employeeRepository.save(existingEmployee);
} 
public void deleteEmployee(Long id) {
    employeeRepository.deleteById(id);
}
}
