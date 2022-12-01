package com.springBoot.Advanced.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping ("/mycode")
    public String helloWorld(){
        System.out.println("I am inside the hello world");
        return  "Welcome to Daily Code";
    }

}


