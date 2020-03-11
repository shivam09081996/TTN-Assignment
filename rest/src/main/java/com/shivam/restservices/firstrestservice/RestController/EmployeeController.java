package com.shivam.restservices.firstrestservice.RestController;

import com.shivam.restservices.firstrestservice.Model.Employee;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@Api(description = "This is the first and basic rest Controller. This was made for practice")
@RestController
public class EmployeeController {

    Employee get;

    @ApiOperation(value ="this is to get an employee" )
    @GetMapping("/get-employee")
    public Employee employee()
    {
        return new Employee(1,"Shivam", 21);
    }

    @ApiOperation(value ="this is to get all employees")
    @RequestMapping(method = RequestMethod.GET, path ="/employees")
    public List<Employee> list()
    {
        return Arrays.asList(new Employee(1,"Shivam Arora",21),
                new Employee(2,"Mayank Arora",19));
    }
    @ApiOperation(value = "this is to get particular employee using id" )
    @RequestMapping(method = RequestMethod.GET, path = "/employee/{id}")
    public Employee getEmployee(@PathVariable int id)
    {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee(1,"Shivam",20));
        list.add(new Employee(2,"Mayank",20));


        for (Employee a:list)
        {
            if(a.getId()==id)
            {
                get = a;
                break;
            }

        }
        return get;
    }
}
