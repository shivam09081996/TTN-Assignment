package com.example.JPAApplication;
import com.example.JPAApplication.Entity.Address;
import com.example.JPAApplication.Entity.Author;
import com.example.JPAApplication.Entity.Subjects;
import com.example.JPAApplication.Repository.Repository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

@SpringBootTest
	class JpaApplicationTests {

	@Autowired
	Repository repository;

	@Test
	void contextLoads() {
	}

	@Test
	public void createEntity(){
		Author author=new Author();
		author.setAuthorName("vinod kumar");

		Address address=new Address();

		address.setStreetnumber(1);
		address.setState("up");
		address.setLocation("muradabad");

		author.setAddress(address);



		HashSet<Subjects> subject=new HashSet<>();

		Subjects sub1=new Subjects();
		sub1.setSubjectName("maths");
		sub1.setAuthor(author);
		subject.add(sub1);

		Subjects sub2=new Subjects();
		sub2.setSubjectName("biology");
		sub2.setAuthor(author);
		subject.add(sub2);

		Subjects sub3=new Subjects();
		sub3.setSubjectName("chemistry");
		sub3.setAuthor(author);
		subject.add(sub3);

		author.setSubjects(subject);

		repository.save(author);


	}

}