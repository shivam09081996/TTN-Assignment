package com.shivam.restservices.firstrestservice.RestController;


import com.shivam.restservices.firstrestservice.Exceptions.EmployeeNotFound;
import com.shivam.restservices.firstrestservice.Model.Employee;
import com.shivam.restservices.firstrestservice.Service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;

//import org.springframework.hateoas.EntityModel;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
//import org.springframework.hateoas.server.mvc.WebMvcLinkBuilderDsl;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
//import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@Api(description = "this is the main rest controller for employee")
public class EmployeeMethods {

    @Autowired
    EmployeeService employeeService;



    // find All Employees
    @ApiOperation(value = "this is to find All Employees")
    @GetMapping("/Employees")
    public List<Employee> list()
    {
       return  employeeService.findAll();
    }



    // find Particular Employee
    @ApiOperation(value = "this is to get particular employee using id")
    @GetMapping("Employee/{id}")
    public Employee get(@PathVariable int id)

    {
        Employee e = employeeService.getParticularEmployee(id);
        if(e == null)
        {
            throw new EmployeeNotFound("id"+ id+"Not found");
        }
        return e;
    }


    @GetMapping("/users/{id}")
    public EntityModel<Employee> retrieveUser(@PathVariable int id) {
        Employee user = employeeService.getParticularEmployee(id);

        if(user==null)
            throw new EmployeeNotFound("id-"+ id);


        //"all-users", SERVER_PATH + "/users"
        //retrieveAllUsers
        EntityModel<Employee> resource = new EntityModel<Employee>(user);

        WebMvcLinkBuilder linkTo =
                linkTo(methodOn(this.getClass()).list());

        resource.add(linkTo.withRel("all-users"));

        //HATEOAS

        return resource;
    }


//    @GetMapping("Employee/{id}")
//    public Resource<Employee> retrieveUser(@PathVariable int id) {
//        Employee  user = service.findOne(id);
//
//        if(user==null)
//            throw new UserNotFoundException("id-"+ id);
//
//
//        //"all-users", SERVER_PATH + "/users"
//        //retrieveAllUsers
//        Resource<User> resource = new Resource<User>(user);
//
//        ControllerLinkBuilder linkTo =
//                linkTo(methodOn(this.getClass()).retrieveAllUsers());
//
//        resource.add(linkTo.withRel("all-users"));
//
//        //HATEOAS
//
//        return resource;
//    }
//
//









    // saving the employee
    @ApiOperation(value = "this is to save an employee")
    @PostMapping("/Employee")
    public Employee save(@RequestBody Employee e)
    {
        return employeeService.save(e);
    }

    @ApiOperation(value = "this is to save an employee using validity")
    @PostMapping("/Employee2")
    public ResponseEntity<Object> giveStatus(@Valid @RequestBody Employee e)
    {
        Employee ee = employeeService.save(e);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(ee.getId()).toUri();
        return ResponseEntity.created(location).build();
    }


    // deleting an Employee
    @ApiOperation(value = "this is to Delete an employee")
    @DeleteMapping("/Employee/{id}")
    public void delete(@PathVariable int id)
    {
        Employee user = employeeService.delete(id);

        if(user==null)
            throw new EmployeeNotFound("id-"+ id);
    }


    // update the employee
    @ApiOperation( value = "update employee",
            notes = "this is to update an employee")
    @PutMapping("/Employee")
    public void update(@RequestBody Employee e)
    {
        employeeService.update(e);
    }

}
