package com.CRUDproject.em_projectCRUD.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

//No need to write any query to create table in database,it will be automatically created by JPA based on this entity class

@Data
@Entity
//To specify table name in database and to which this entity class is mapped
@Table(name = "emp_db")
public class EmployeeEntity {
    //for primary key 
    @Id
    //for auto generation of primary key value
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String phone;
    private String email;
    
}