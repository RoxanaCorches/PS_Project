package com.example.project_ps_real.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name ="answers")
@Setter
@Getter
public class Answers {

    @Id
    @Column(name="answer_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="picture")
    private String picture;

    @Column(name="date")
    private Date date;

    @Column(name="likes")
    private Integer likes;

    @Column(name="dislikes")
    private Integer dislikes;

    public Answers(Long answerId, Post post, User user, String picture, Date date, Integer likes, Integer dislikes) {
        this.answerId = answerId;
        this.post = post;
        this.user = user;
        this.picture = picture;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
    }

    public Answers() {

    }
}
