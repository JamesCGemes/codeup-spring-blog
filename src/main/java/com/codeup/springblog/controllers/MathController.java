package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
//Add numbers from url input
    @RequestMapping(path = "/add/{num1}/and/{num2}",method = RequestMethod.GET)
    @ResponseBody
    public String addNums(@PathVariable int num1,@PathVariable int num2){
        return num1 + " plus " + num2 + " equals " + (num1 + num2);
    }
//   Subtracts numbers from url input
    @RequestMapping(path = "/subtract/{num1}/from/{num2}",method = RequestMethod.GET)
    @ResponseBody
    public String subtractNums(@PathVariable int num1,@PathVariable int num2){
            return num1 + " subtract " + num2 + " equals " + (num1 - num2);
    }
//  Multiply numbers from url input
    @RequestMapping(path = "/multiply/{num1}/and/{num2}",method = RequestMethod.GET)
    @ResponseBody
    public String multiplyNums(@PathVariable int num1,@PathVariable int num2){
        return num1 + " X " + num2 + " equals " + (num1 * num2);
    }
//    Divide numbers from url input
    @RequestMapping(path = "/divide/{num1}/and/{num2}",method = RequestMethod.GET)
    @ResponseBody
    public String divideNums(@PathVariable int num1,@PathVariable int num2){
        return num1 + " / " + num2 + " equals " + (num1 / num2);
    }
}
