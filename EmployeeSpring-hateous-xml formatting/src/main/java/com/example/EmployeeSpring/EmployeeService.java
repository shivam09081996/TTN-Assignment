package com.example.EmployeeSpring;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;



@Component

public class EmployeeService {
    private  static List<Employee> employeesList=new ArrayList<>();
    private static int empcount=3;

    static {
        employeesList.add(new Employee(1,"prajjwal",new Date()));
        employeesList.add(new Employee(2,"Pranjal",new Date()));
        employeesList.add(new Employee(3,"vinod",new Date()));
    }

    public List<Employee> findall(){
        return employeesList;
    }



    public Employee save(Employee employee){
        if(employee.getId()==null)
            employee.setId(++empcount);
        employeesList.add(employee);
        return employee;
    }



    public Employee findone(int id){
        for(Employee emp:employeesList){
            if(emp.getId()==id){
                return  emp;
            }

        }
        return null;
    }

    public Employee deleteUserById(int id){
        Iterator<Employee> iterator=employeesList.iterator();
        while (iterator.hasNext()){
                Employee employee=iterator.next();
                if(employee.getId()==id){
                    iterator.remove();
                    return employee;

                }
        }
        return null;
    }

}
