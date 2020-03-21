package com.example.JPAApplication.EmployeeRepo;

import com.example.JPAApplication.EmployeeEntity.Employee;
import org.springframework.data.repository.CrudRepository;
public interface EmployeeRepo extends CrudRepository<Employee,Integer>{


}
