package com.example.JPAApplication.EmployeeRepo;

import com.example.JPAApplication.EmployeeEntity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>{

}
