package com.CRUDproject.em_projectCRUD.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.CRUDproject.em_projectCRUD.model.Employee;
import com.CRUDproject.em_projectCRUD.services.EmployeeService;
import com.CRUDproject.em_projectCRUD.services.EmployeeServiceImpl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class EmpController {
    // List<Employee> employees=new ArrayList<>();



    // As we cannot create a instance of a interface so we will create a instance of the class that implements this interface
    EmployeeService employeeService = new EmployeeServiceImpl();

    //  or

    //Dependency Injection(Not a good practice to create object like this in spring boot application as spring framework provides ioc container to manage the objects and their dependencies)
    //@Autowired
    //EmployeeService employeeService; //this will be automatically injected by spring framework and ioc container,the object of EmployeeServiceImpl class will be created and assigned to this reference variable by spring framework( ioc container)

    @GetMapping("employees")
    public List<Employee> getAllEmployees() {
        return employeeService.readEmployees();
    }  

    @PostMapping("employees")
    public String createEmployee(@RequestBody Employee employee) {
       //TODO: process POST request
        //  employees.add(employee);
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        
        if(employeeService.deleteEmployee(id)){
            return "Employee deleted successfully";
        } 
         return "Failed to delete employee";
        
    }
}
