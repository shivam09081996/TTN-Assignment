package com.shivam.restservices.firstrestservice.filter;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.shivam.restservices.firstrestservice.Model.User;
import org.springframework.stereotype.Component;

@Component
public class DynamicFilter {

    public FilterProvider filterElement(String x) {
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(x);

        FilterProvider filters = new SimpleFilterProvider().addFilter("FilterAdded", filter);

        return filters;
    }
}
