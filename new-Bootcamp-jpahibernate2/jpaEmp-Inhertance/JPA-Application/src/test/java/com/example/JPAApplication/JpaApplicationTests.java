package com.example.JPAApplication;

import com.example.JPAApplication.EmployeeEntity.Employee;
import com.example.JPAApplication.EmployeeEntity.RegularEmployee;
import com.example.JPAApplication.EmployeeEntity.TraineeEmployee;
import com.example.JPAApplication.EmployeeRepo.EmployeeRepo;
import org.hibernate.exception.GenericJDBCException;
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

	  //methods for inheritance in hybernate

		@Test
		  public void createTable(){
		  Employee employee=new RegularEmployee("prajjwal","pandey",23,15100,"hybernate");
		  repository.save(employee);
		  Employee employee1=new TraineeEmployee("pranjal","pandey",20,10000,100);
		  repository.save(employee1);

		  Employee employee2=new TraineeEmployee("Vinod","pandey",20,10000,100);
		  repository.save(employee2);

		}

}