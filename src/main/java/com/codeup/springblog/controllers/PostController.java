package com.codeup.springblog.controllers;


import com.codeup.springblog.models.Post;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PostController {




    @RequestMapping(path = "posts",method = RequestMethod.GET)
    public String postIndex(Model model){
        Post post01 = new Post("First Post", "My first post", 1);
        Post post02 = new Post("Second Post", "My second post", 2);
        Post post03 = new Post("Third Post", "My third post", 3);

        List<Post> postList = new ArrayList<>();
        postList.add(post01);
        postList.add(post02);
        postList.add(post03);

        return "posts/index";

    }



    @RequestMapping(path = "/posts/{id}", method = RequestMethod.GET)
    public String postView(Model model){
        Post post = new Post("First Post", "Post number 1", 1);
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
