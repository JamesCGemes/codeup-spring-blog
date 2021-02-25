package com.codeup.springblog.controllers;


import com.codeup.springblog.models.*;
import com.codeup.springblog.repositories.PostRepository;
import com.codeup.springblog.repositories.UserRepository;
import com.codeup.springblog.services.EmailService;
import com.codeup.springblog.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class PostController {

    private final PostRepository postData;
    private final UserRepository userData;
    private final UserService userService;
    private final EmailService emailService;

    public PostController(PostRepository postData, UserRepository userData, EmailService emailService, UserService userService) {
        this.postData = postData;
        this.userData = userData;
        this.emailService = emailService;
        this.userService = userService;
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




    @GetMapping("/posts/delete")
    public String deletePost(@RequestParam long id, Model model){
        postData.deleteById(id);
        model.addAttribute("posts",postData.findAll());
        return "posts/index";
    }





    @GetMapping("posts/create")
    public String postForm(Model model){
        model.addAttribute("post", new Post());
        return "posts/create";
    }





    @PostMapping("/posts/create")
    public String createPost(@RequestParam String title,@RequestParam String body){
        User user = userService.loggedInUser();

        Post post = new Post();
        post.setUser(user);
        post.setTitle(title);
        post.setBody(body);
        postData.save(post);
        emailService.prepareAndSend(post,"Good job", "you made a post"+ post.getTitle());
        return "redirect:/posts/";
    }

    @GetMapping("posts/{id}/edit")
    public String editPostForm(Model model, @PathVariable long id){
        Post post = postData.getOne(id);
        model.addAttribute("post", post);
        return "/posts/edit";
    }

    @PostMapping(path = "posts/{id}/edit")
    public String editPost(@ModelAttribute Post post){
        postData.save(post);
        return "redirect:/posts/";
    }



}
