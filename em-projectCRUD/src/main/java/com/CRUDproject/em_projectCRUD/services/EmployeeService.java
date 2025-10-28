package com.CRUDproject.em_projectCRUD.services;

import java.util.List;

import com.CRUDproject.em_projectCRUD.model.Employee;

public interface EmployeeService {
    String createEmployee(Employee employee);
    List<Employee> readEmployees();
    boolean deleteEmployee(Long id);
    String updateEmployee(Long id, Employee employee);
    Employee readEmployee(Long id);
}
