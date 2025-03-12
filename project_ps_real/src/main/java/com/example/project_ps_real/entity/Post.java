package com.example.project_ps_real.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name ="posts")
@Setter
@Getter
public class Post {
    @Id
    @Column(name="post_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    @Column(name="date")
    private Date date;

    @Column(name="title")
    private String title;

    @Column(name="text")
    private String text;

    @Column(name="image")
    private String image;

    @Column(name="status")
    private String status;

    @Column(name="likes")
    private Integer likes;

    @Column(name="dislikes")
    private Integer dislikes;

    @ManyToMany
    @JoinTable(
            name = "post_tag",  // Name of the join table
            joinColumns = @JoinColumn(name = "post_id"),  // Foreign key for PostTag
            inverseJoinColumns = @JoinColumn(name = "tag_id")  // Foreign key for Post
    )
   //private List<Post> posts;
    private List<Tag> tags;
    public Post(){
    }

    public Post(Long postId, User user, Date date, String title, String text, String image, String status, Integer likes, Integer dislikes, List<Tag> tags) {
        this.postId = postId;
        this.user = user;
        this.date = date;
        this.title = title;
        this.text = text;
        this.image = image;
        this.status = status;
        this.likes = likes;
        this.dislikes = dislikes;
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "postId=" + postId +
                ", user=" + user +
                ", date=" + date +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", image='" + image + '\'' +
                ", status='" + status + '\'' +
                ", likes=" + likes +
                ", dislikes=" + dislikes +
                ", tags=" + tags +
                '}';
    }
}