package com.example.project_ps_real.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name ="tag")
@Setter
@Getter
public class Tag {
    @Id
    @Column(name="tag_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tagId;

    @Column(name="name")
    private String name;



    @ManyToMany(mappedBy = "tags") // Legătura inversă de la Post -> Tag
    private List<Post> posts;


    public Tag(Long tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public Tag() {

    }

}
