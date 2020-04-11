package com.example.EmployeeSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@RestController
public class EmployeeResource {

    @Autowired

    private EmployeeService service;


    @GetMapping("/employees")

    public List<Employee> retrieveAllEmployee(){
        return service.findall();
    }

    @GetMapping("/employees/{id}")

    public Employee retrieveEmployee(@PathVariable int id){
          Employee  employee= service.findone(id);
        if(employee==null)
            throw new UserNotFoundEception("id-"+id);
           return  employee;
           }

         /*  @PutMapping("/employees")
           public void Updatemp(@RequestBody Employee employee){
              Employee updateemp=service.UpdateEmployee(employee);
           }
*/

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
