package com.example.JPAApplication.EmployeeRepo;

import com.example.JPAApplication.EmployeeEntity.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeRepo extends CrudRepository<Employee,Integer>{

    //JPQL
    //___________________________________________________________________________________________________________________
         @Query("from Employee e where e.salary>(select AVG(e.salary) from Employee e) order by e.age ASC,e.salary DESC")
         List<Employee> findAllEmployeeAscDesc();

         @Transactional
         @Modifying
         @Query("delete from Employee e where e.salary=(select MIN(e.salary) from Employee e)")
         public void delete();

      //_________________________________________________________________________________________________________________



    //Native Query
    //___________________________________________________________________________________________________


    @Query(value = "select e.id,e.fname,e.age from employee e where e.lname='singh'",nativeQuery = true)
         List<Object[]> findEmployeeBYLastName();

    @Transactional
    @Modifying
    @Query(value="delete from employee  where age>:yourage",nativeQuery = true)
        public void deleteAgeGreater(@Param("yourage") int ag);

}
