package com.CRUDproject.em_projectCRUD.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
//this is model class
public class Employee {
    private Long id;
    private String name;
    private String phone;
    private String email;

    // no need to make public getter and setter manually,it will be automatically created by LOMBOK for all the fields
    // public String getName() {
    //     return name;
    // }
    // public void setName(String name) {
    //     this.name = name;
    // }
}
