package com.example.project_ps_real.service;

import com.example.project_ps_real.entity.Post;
import com.example.project_ps_real.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Service
public class PostService {
    private PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> retrieveAll() {
        return (List<Post>) this.postRepository.findAll();
    }

    public Post findByIdPost(Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()){
            System.out.println(post.get());
            System.out.println("bbbhjsgbf");
            return post.get();
        }else{
            return null;
        }
    }

    public Post addPost(Post post) {
        System.out.println("Post: " + post.toString());
        return this.postRepository.save(post);
    }

    public Post updatePost(Post post) {
        Optional<Post> isPost=postRepository.findById(post.getPostId());
        if(isPost.isPresent()){
            System.out.println("Post with id:"+post.getPostId());
            return this.postRepository.save(post);
        }else{
            System.out.println("Post is not found!");
            return null;
        }
    }
    public String deletePostById(Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()) {
            this.postRepository.deleteById(id);
            return "Entry successfully deleted!";
        }
        else {
            return "Failed to delete user with id " + id;
        }
    }


}
