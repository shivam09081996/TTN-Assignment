package com.example.HelloWorldSpring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;


    @GetMapping(path = "/helloworldInternationalization")
    public String hello( @RequestHeader(name = "Accept-Language") Locale locale, @RequestParam(name = "na") String na) {
        return messageSource.getMessage("good.morning.message", new Object[]{na}, locale);
    }

}

