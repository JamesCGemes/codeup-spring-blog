package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {




    @RequestMapping(path = "posts",method = RequestMethod.GET)
    @ResponseBody
    public String index(){
        return "posts index page";
    }




    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postView(Model model){
        Post post = new Post("First Post", "This is my first paost", 1);
        model.addAttribute("title","Single Posts");
        model.addAttribute("post", post);
        return "posts/show";
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
