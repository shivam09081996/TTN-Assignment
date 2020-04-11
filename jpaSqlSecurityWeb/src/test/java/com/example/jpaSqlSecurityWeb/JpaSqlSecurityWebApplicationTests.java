package com.example.jpaSqlSecurityWeb;

import com.example.jpaSqlSecurityWeb.Entity.User;
import com.example.jpaSqlSecurityWeb.UserRepo.UserRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JpaSqlSecurityWebApplicationTests {

	@Autowired
	UserRepo userRepo;
	@Test
	void contextLoads() {
	}


	@Test
	public void createEntity(){
		User user=new User();
		user.setUserName("prajjwal");
		user.setPassword("prajjwal");
		user.setRoles("ROLE_USER");
		user.setActive(true);

       userRepo.save(user);

	}
}
