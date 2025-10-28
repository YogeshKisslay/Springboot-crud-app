package com.CRUDproject.em_projectCRUD.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CRUDproject.em_projectCRUD.model.Employee;
import com.CRUDproject.em_projectCRUD.repository.EmployeeRepository;
import com.CRUDproject.em_projectCRUD.entity.EmployeeEntity;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    // instead of using another way of creating object of EmployeeRepository interface by creating a class that implements this interface we will use Dependency Injection provided by spring framework and ioc container to create the object of EmployeeRepository interface
    @Autowired   //this will inject the EmployeeRepository bean created by spring framework and ioc container,means the object of EmployeeRepository interface will be created by spring framework and assigned to this reference variable
    private EmployeeRepository employeeRepository;


    @Override
    public String createEmployee(Employee employee) {
       //now we will convert our model class object to entity class object and then save it to database using employeeRepository
        EmployeeEntity employeeEntity=new  EmployeeEntity();
        //now wil copy data from employee model to employee entity
        //src to dependencies
        BeanUtils.copyProperties(employee,employeeEntity);

        //Now will store this entity in our database using Repository 
        employeeRepository.save(employeeEntity);  //in the table using repository
        
        // employees.add(employee);  //localy
        return "Successfully added employee";
    }


    //one employee by id
    @Override
    public Employee readEmployee(Long id) {
       EmployeeEntity empEntity=employeeRepository.findById(id).orElse(null);
         if(empEntity==null){
          return null;
         }
        Employee emp=new Employee(); //model
        //now we will copy data from empEntity to emp model,or we can do it manually by using setter methods also like we done in getallemployees method
        BeanUtils.copyProperties(empEntity, emp);
        return emp;
    }


    @Override
    public List<Employee> readEmployees() {
        //we will get all the data from the repository and and save them in a list of employeentity
       List<EmployeeEntity> employeesList=employeeRepository.findAll();
       //now again copy the employeeEntity list data to a list of employees
        List<Employee> employees=new ArrayList<>();
        for(EmployeeEntity employeeEntity:employeesList){
            Employee emp=new Employee(); //model
            emp.setId(employeeEntity.getId());
            emp.setName(employeeEntity.getName());
            emp.setEmail(employeeEntity.getEmail());
            emp.setPhone(employeeEntity.getPhone());
            employees.add(emp);
        }
       return employees;
    }

    

    @Override
    public boolean deleteEmployee(Long id) {
       
        // if(employees.removeIf(emp -> emp.getId().equals(id))) {
        //     return true;
        // }
        EmployeeEntity empEntity=employeeRepository.findById(id).orElse(null);
        if(empEntity!=null){
            employeeRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public String updateEmployee(Long id, Employee employee) {
        EmployeeEntity existingEmployee=employeeRepository.findById(id).orElse(null);
        if(existingEmployee==null){
            return "Employee not found";
        }
        
        existingEmployee.setName(employee.getName());
        existingEmployee.setEmail(employee.getEmail()); 
        existingEmployee.setPhone(employee.getPhone());

        employeeRepository.save(existingEmployee);
        return "Upated Successfully";
        
    }

}
