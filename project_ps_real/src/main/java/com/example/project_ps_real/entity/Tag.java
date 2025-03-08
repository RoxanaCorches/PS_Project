package com.example.project_ps_real.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

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

    @ManyToOne
    @JoinColumn(name = "user_id")  // Cheie străină către User
    private User user;

    public Tag(Long tagId, String name) {
        this.tagId = tagId;
        this.name = name;
    }

    public Tag() {

    }
}
