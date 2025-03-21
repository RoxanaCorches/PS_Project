package com.example.project_ps_real.controller;

import com.example.project_ps_real.entity.Post;
import com.example.project_ps_real.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/getAll")
    @ResponseBody
    public List<Post> getAllPost(){
        return this.postService.retrieveAll();
    }

    @GetMapping("/getById")
    @ResponseBody
    public Post getPostById(@RequestParam("id") Long id) {
        Post post =this.postService.findById(id);
        return post;
    }

    @PostMapping("/addPost")
    @ResponseBody
    public Post addPost(@RequestBody Post post) {
        return this.postService.addPost(post);
    }

    @PutMapping("/updatePost")
    @ResponseBody
    public Post updatePost(@RequestBody Post post) {
        return this.postService.addPost(post);
    }
    @DeleteMapping("/deleteById")
    @ResponseBody
    public String deletePostById(@RequestParam Long id) {
        return this.postService.deletePostById(id);

    }
}
