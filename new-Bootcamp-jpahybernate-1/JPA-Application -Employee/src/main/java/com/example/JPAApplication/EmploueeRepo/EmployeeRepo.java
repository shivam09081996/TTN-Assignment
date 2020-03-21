package com.example.JPAApplication.EmploueeRepo;

import com.example.JPAApplication.EmployeeEntity.Employee;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface EmployeeRepo extends PagingAndSortingRepository<Employee,Integer> {

    List<Employee> findByName(String name);

    List<Employee> findByAgeBetween(int age1,int age2);

    List<Employee> findByNameStartingWith(String alphabet);

}
