package com.example.EmployeeSpring;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
public class EmployeeResource {

    @Autowired

    private EmployeeService service;


    @GetMapping("/employees")

    public List<Employee> retrieveAllEmployee(){
        return service.findall();
    }


    //Here we Create Hateous

    @GetMapping("/employees/{id}")

    public Employee retrieveEmployee(@PathVariable int id){

          Employee  employee= service.findone(id);
        if(employee==null)
            throw new UserNotFoundEception("id-"+id);

                Link link = linkTo(methodOn(EmployeeResource.class)
                .retrieveAllEmployee()).withRel("All employee");

                employee.setLink(link);

        return  employee;
           }


                   @PostMapping("/employees")
    public void createEmployee(@Valid  @RequestBody Employee employee){
        Employee savedemployee=service.save(employee);
           }


    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id){
        Employee  employee= service.deleteUserById(id);
        if(employee==null)
            throw new UserNotFoundEception("id-"+id);

          }
          }
