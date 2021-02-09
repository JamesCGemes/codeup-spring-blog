package com.codeup.springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {

    @GetMapping("/hello")

    @ResponseBody
    public String hello(){
        return "Hello from spring";
    }

//    This will take what you type into the hello URL path and concat it to Hello.
    @GetMapping("/hello/{name}")
    @ResponseBody
    public String sayHello(@PathVariable String name){
        return "Hello " + name + "!";
    }

//    with requestmapping you can tell it to GET or POST
    @RequestMapping(path = "/increment/{number}",method = RequestMethod.GET)
    @ResponseBody
    public String addOne(@PathVariable  int number){
        return number + " plus one is " + (number + 1) + "!";
    }
}
