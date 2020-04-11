package com.example.jpaSqlSecurityWeb.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

        @GetMapping("/")
        public String alluser(){
        return "hello";
        }

        @GetMapping("/user")
        public String user(){
            return "hello-user";
        }

        @GetMapping("/admin")
        public String admin(){
            return "hello-admin";
        }

}
