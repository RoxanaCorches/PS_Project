package com.example.project_ps_real.service;
import com.example.project_ps_real.entity.Tag;
import com.example.project_ps_real.entity.User;
import com.example.project_ps_real.repository.TagRepository;
import com.example.project_ps_real.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private TagRepository tagRepository;
    private UserRepository userRepository;
    @Autowired
    public TagService(TagRepository tagRepository, UserRepository userRepository) {
        this.tagRepository = tagRepository;
        this.userRepository = userRepository;
    }


    public List<Tag> getAllTag(){
        return (List<Tag>) this.tagRepository.findAll();
    }

    public Tag getTagById(Long id) {
        Optional<Tag> tag=this.tagRepository.findById(id);
        if(tag.isPresent()){
            System.out.println("Tag found with ID: " + id);
            return tag.get();
        }
        else
        {
            System.out.println("Tag not found!");
            return null;
        }

    }

    public Tag addTag(Tag tag,Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new RuntimeException("User not found");
        }
        tag.setUser(user);
        return tagRepository.save(tag);
    }


}
