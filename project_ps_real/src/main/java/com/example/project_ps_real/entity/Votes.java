package com.example.project_ps_real.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "votes")
@Getter
@Setter
public class Votes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vote_id")
    private Long voteId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answers answer;

    @Column(name = "is_liked", nullable = false)
    private Boolean isLiked;

    public Votes() {
    }

    public Votes(User user, Post post, Boolean isLiked) {
        this.user = user;
        this.post = post;
        this.answer = null;
        this.isLiked = isLiked;
    }

    public Votes(User user, Answers answer, Boolean isLiked) {
        this.user = user;
        this.post = null;
        this.answer = answer;
        this.isLiked = isLiked;
    }
/*
    public Votes(Long voteId, User user, Post post, Answers answer, Boolean isLiked) {
        this.voteId = voteId;
        this.user = user;
        this.post = post;
        this.answer = answer;
        this.isLiked = isLiked;
    }

 */
}
