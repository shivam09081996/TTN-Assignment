package com.example.JPAApplication;

import com.example.JPAApplication.EmployeeEntity.Employee;
import com.example.JPAApplication.EmployeeEntity.Salary;
import com.example.JPAApplication.EmployeeRepo.EmployeeRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
@SpringBootTest
	class JpaApplicationTests {

	@Autowired
	EmployeeRepo repository;

	@Test
	void contextLoads() {
	}

	@Test
    void createEmbadedTable(){
		Employee employee=new Employee();
		employee.setFname("prajjwal");
		employee.setLname("pandey");
		employee.setAge(23);
		Salary salary=new Salary();
		salary.setBasicsalary(10000);
		salary.setBonoussalary(12000);
		salary.setTaxamount(2000);
		salary.setSpecialallowencesalary(29990);
		employee.setSalary(salary);
		repository.save(employee);
	}

}