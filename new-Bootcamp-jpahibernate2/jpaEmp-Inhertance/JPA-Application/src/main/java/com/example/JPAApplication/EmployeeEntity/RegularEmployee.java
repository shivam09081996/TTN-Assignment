package com.example.JPAApplication.EmployeeEntity;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("RegularEmployee")
public class RegularEmployee extends Employee{

    private String project;


    public RegularEmployee(String fname, String lname, int age, int salary,String project) {
        super( fname, lname, age, salary);

        this.project=project;
    }
}
