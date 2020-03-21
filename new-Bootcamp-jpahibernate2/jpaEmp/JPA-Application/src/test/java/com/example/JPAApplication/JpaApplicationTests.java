package com.example.JPAApplication;

import com.example.JPAApplication.EmployeeEntity.Employee;
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
		public void createEmployee() {
		Employee employee = new Employee();
		employee.setFname("prajjwal");
		employee.setLname("pandey");
		employee.setAge(23);
		employee.setSalary(20000);

		repository.save(employee);
	}
     //MEthods for jpql_____________________________________________________________________________________________
		@Test
		public void AllEmployeeAscDesc() {
		System.out.println("________________________________________________________");
		System.out.println(repository.findAllEmployeeAscDesc());

		System.out.println("________________________________________________________");
		}

		/*@Test
	    public void DeleteEmployee(){
		repository.delete();
	     }*/

		//____________________________________________________________________________________________________________

         //Methods for native Query____________________________________________________________________________________
			@Test
			public void displayNameEnd(){
        	List<Object[]> partialdata= repository.findEmployeeBYLastName();
        	for (Object[] objects:partialdata){
			System.out.println(objects[0]);
			System.out.println(objects[1]);
			System.out.println(objects[2]);
			}
			}

			@Test
	        public void deleteAge(){repository.deleteAgeGreater(45);}




          //____________________________________________________________________________________________________________


}