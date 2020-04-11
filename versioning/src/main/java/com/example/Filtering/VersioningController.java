package com.example.Filtering;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningController {

    //URI versioning

    @GetMapping("/Details/v1")

    public UserdetailsV1 userdetailsV1(){
        return new UserdetailsV1("prajjwal");
    }

    @GetMapping("/Details/v2")

    public UserDetailsV2 userDetailsV2(){
        return new UserDetailsV2(new UserDetails("Prajjwal","Pandey",23));
    }

       //param versioning
    @GetMapping(value="/Details/param",  params = "version=1")

    public UserdetailsV1 paramV1(){
        return new UserdetailsV1("prajjwal");
    }
    @GetMapping(value = "/Details/param",params = "version=2")

    public UserDetailsV2 paramV2(){
        return new UserDetailsV2(new UserDetails("Prajjwal","Pandey",23));
    }


       //Header versioing

    @GetMapping(value="/Details/param",  headers = "x-version=1")

    public UserdetailsV1 HeaderV1(){
        return new UserdetailsV1("prajjwal");
    }

    @GetMapping(value = "/Details/header", headers = "x-version=2")

    public UserDetailsV2 HeaderV2(){
        return new UserDetailsV2(new UserDetails("Prajjwal","Pandey",23));
    }


    //MimeType Versioning


    @GetMapping(value="/Details/produces",  produces = "application/vnd.company.app-v1+json")

    public UserdetailsV1 MimeV1(){
        return new UserdetailsV1("prajjwal");
    }




}
