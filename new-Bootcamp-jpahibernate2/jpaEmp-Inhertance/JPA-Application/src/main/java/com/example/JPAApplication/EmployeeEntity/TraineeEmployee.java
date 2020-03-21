package com.example.JPAApplication.EmployeeEntity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
@Entity
@DiscriminatorValue("TraineeEmployee")
public class TraineeEmployee extends Employee {
    private int assesmentScore;


    public TraineeEmployee( String fname, String lname, int age, int salary,int assesmentScore) {
        super(fname, lname, age, salary);
        this.assesmentScore=assesmentScore;
    }
}
