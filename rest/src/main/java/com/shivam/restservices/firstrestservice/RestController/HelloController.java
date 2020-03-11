package com.shivam.restservices.firstrestservice.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

// Controller
@RestController
public class HelloController {

    @Autowired
    private MessageSource messageSource;

    //Get
    //URI
    //Method
    @RequestMapping(method = RequestMethod.GET, path = "/hello")
    public String Hello()
    {
        return "Welcome to Spring Boot";
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWorldInternationalized() {
        return messageSource.getMessage("good.morning.message", null,
                LocaleContextHolder.getLocale());
    }


    @GetMapping("/Hello/Username")
    public String getUsername(@RequestParam(name = "Name") String name)
    {
        return "Hello "+name;
    }

}
