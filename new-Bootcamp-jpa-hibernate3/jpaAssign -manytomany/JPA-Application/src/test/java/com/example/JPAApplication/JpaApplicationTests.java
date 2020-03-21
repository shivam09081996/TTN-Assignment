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
         author.setAuthorName("prajjwal");
         Address address=new Address();
         address.setState("CG");
         address.setLocation("Korba");
         address.setStreetnumber(1);

         author.setAddress(address);

         HashSet<Author> authors=new HashSet<>();
         authors.add(author);

         Subjects sub1=new Subjects();

         HashSet<Subjects> subjects=new HashSet<>();
         sub1.setAuthor(authors);

         sub1.setSubjectName("Maths");
         subjects.add(sub1);

         author.setSubjects(subjects);


        repository.save(author);

		}



}