package com.shivam.restservices.firstrestservice.Service;

import com.shivam.restservices.firstrestservice.Model.Employee;
import org.springframework.stereotype.Component;
import java.util.*;
import org.springframework.stereotype.Service;

@Component
public class EmployeeService {
    private static List<Employee> employee = new ArrayList<>();

    private static int count = 3;

    static
    {
        employee.add(new Employee(1,"A",21));
        employee.add(new Employee(2,"B",22));
        employee.add(new Employee(3,"C",23));
    }

    // get all employees

    public List<Employee> findAll()
    {
        return employee;
    }

    //get particular employee

    public Employee getParticularEmployee(int id)
    {
        for(Employee e: employee)
        {
            if(e.getId()==id)
                return e;

        }
        return null;
    }

    // create a new Employee
    public Employee save(Employee e)
    {
        employee.add(e);
        return  e;
    }

    // deleting an Employee
    public Employee delete(int id)
    {
        Iterator<Employee> itr = employee.iterator();
        while (itr.hasNext()) {
            Employee e = itr.next();
            if (e.getId() == id) {
                itr.remove();
                return e;
            }

        }
        return null;
    }



    // put request

    public List<Employee> update(Employee e)
    {
        for(Employee emp:employee)
        {
            if(emp.getId()==e.getId())
            {
                employee.remove(emp);
            }
            employee.add(e);
        }
        return  employee;
    }
}
