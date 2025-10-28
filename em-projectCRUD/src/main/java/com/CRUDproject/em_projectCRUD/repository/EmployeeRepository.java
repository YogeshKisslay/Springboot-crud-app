package com.CRUDproject.em_projectCRUD.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CRUDproject.em_projectCRUD.entity.EmployeeEntity;

//This repository interface will help to perform CRUD operations on EmployeeEntity table in database and JpaRepository provides built-in methods for CRUD operations
@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {
    //it already has all the methods like save, findAll, findById, deleteById etc.
    //but can also define custom methods if needed like findByName, findByDepartment etc.
}
