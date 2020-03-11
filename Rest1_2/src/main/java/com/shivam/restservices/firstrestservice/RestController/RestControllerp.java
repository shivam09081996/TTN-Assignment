package com.shivam.restservices.firstrestservice.RestController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerp{




    @GetMapping(path="/preeti")//uri//uri method mein jo bhi define hota h vo return k sath map karta h

    public String preeti() {//method
         return "good morning preeti";
     }


     @GetMapping(path="/shreya")
        public String sh(){
            return "shreya = good girl";

     }
}