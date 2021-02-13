package com.codeup.springblog.controllers;


import com.codeup.springblog.models.*;
import com.codeup.springblog.repositories.PostRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    private final PostRepository postData;

    public PostController(PostRepository postData) {
        this.postData = postData;
    }


    @GetMapping("/posts")
    public String postIndex(Model model){
     model.addAttribute("posts",postData.findAll());

        return "posts/index";

    }


    @GetMapping("/posts/{id}")
    public String postView(Model model, @PathVariable long id){
        Post post = postData.getOne(id);
        model.addAttribute("post", post);
        return "posts/show";
    }
    @PostMapping("/posts/delete")
    public String deletePost(@RequestParam long id, Model model){
        postData.deleteById(id);
        model.addAttribute("posts",postData.findAll());
        return "posts/index";
    }





    @GetMapping("posts/create")
    @ResponseBody
    public String createForm(){
        return "view form to create a post";
    }





    @PostMapping("/posts/create")
    @ResponseBody
    public String createPost(){
        return "create a new post";
    }


}
