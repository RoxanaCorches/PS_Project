package com.example.project_ps_real.service;

import com.example.project_ps_real.entity.Post;
import com.example.project_ps_real.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class PostService {
    private PostRepository postRepository;
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> retrieveAll() {
        return (List<Post>) this.postRepository.findAll();
    }

    public Post findById(Long id) {
        Optional<Post> post = this.postRepository.findById(id);
        if(post.isPresent()){
            return post.get();
        }else{
            return null;
        }
    }

    public Post addPost(Post post) {
        return this.postRepository.save(post);
    }

    public String deletePostById(Long id) {
        try {
            this.postRepository.deleteById(id);
            return "Entry successfully deleted!";
        }catch(Exception e){
            return "Failed to delete entry with id:" + id;
        }
    }
}
