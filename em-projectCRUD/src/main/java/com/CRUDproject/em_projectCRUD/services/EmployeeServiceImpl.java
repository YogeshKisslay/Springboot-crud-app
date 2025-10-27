package com.CRUDproject.em_projectCRUD.services;
import java.util.ArrayList;
import java.util.List;

import com.CRUDproject.em_projectCRUD.model.Employee;

public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees=new ArrayList<>();

    @Override
    public String createEmployee(Employee employee) {
        // TODO Auto-generated method stub
        employees.add(employee);
        return "Successfully added employee";
    }

    @Override
    public java.util.List<Employee> readEmployees() {
        // TODO Auto-generated method stub
        return employees;
    }

    @Override
    public boolean deleteEmployee(Long id) {
        // TODO Auto-generated method stub
        if(employees.removeIf(emp -> emp.getId().equals(id))) {
            return true;
        }
        return false;
    }
    
}
