package com.shivam.restservices.firstrestservice.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shivam.restservices.firstrestservice.Model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(description = "This is the controller to display filter functionality")
public class FilterController {

    @Autowired
    private DynamicFilter dynamicFilter;

    @GetMapping("/user")
    @ApiOperation(value = "static filter")
    public User filter()
    {
        return new User("Shivam","ttn");
    }


    @GetMapping("/filtering/username")
    public MappingJacksonValue retrieveSomeBean() {
        User user = new User("Shivam", "ttn");

//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterAdded", filter);

       FilterProvider filters = dynamicFilter.filterElement("userName");

        MappingJacksonValue mapping = new MappingJacksonValue(user);

        mapping.setFilters(filters);

        return mapping;
    }


    @GetMapping("/filtering/Password")
    public MappingJacksonValue retrieveSomeBean2() {
        User user = new User("Shivam", "ttn");

//        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("userName");
//
//        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterAdded", filter);

        FilterProvider filters = dynamicFilter.filterElement("password");

        MappingJacksonValue mapping = new MappingJacksonValue(user);

        mapping.setFilters(filters);

        return mapping;
    }


}
