package com.example.project_ps_real.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="post_tag")
@Setter
@Getter
public class PostTag {
    @Id
    private Long id;

    @Column(name="tag_id")
    private Integer tagID;

    @Column(name="post_id")
    private  Integer postID;
}
