package com.codeup.springblog.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {




    @RequestMapping(path = "posts",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "posts index page";
    }

    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String individualPost(@PathVariable long id){
        return "View an individual post";
    }

    @RequestMapping(path = "posts/create",method = RequestMethod.GET)
    @ResponseBody
    public String createForm(){
        return "view form to create a post";
    }

    @RequestMapping(path = "/posts/create",method = RequestMethod.POST)
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }


}
