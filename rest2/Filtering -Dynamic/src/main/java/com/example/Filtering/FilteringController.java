package com.example.Filtering;


import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class FilteringController {

    @GetMapping("/userinfo")
    public MappingJacksonValue retrieveDeatails(){

        User user= new User("prajjwal","password",23);
        SimpleBeanPropertyFilter filter=SimpleBeanPropertyFilter.filterOutAllExcept("name","age");
        FilterProvider filters=new SimpleFilterProvider().addFilter("userFilter",filter);

        MappingJacksonValue mapping=new MappingJacksonValue(user);
        mapping.setFilters(filters);

        return mapping;
    }

}
