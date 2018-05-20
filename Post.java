package com.devlabs.springbootdemo;

import javax.persistence.*;

@Entity(name = "Post")
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "title")
    private String title;

    @OneToOne(mappedBy = "post", cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = false)
    private PostDetails postDetails;

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "title='" + title + '\'' +
                ", postDetails=" + postDetails +
                '}';
    }

    public Post() {
    }

    public Post(String title, PostDetails postDetails) {
        this.title = title;
        this.postDetails = postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        if(postDetails == null){
            if(this.postDetails != null) {
                this.postDetails.setPost(null);
            }
        }else {
            postDetails.setPost(this);
        }
        this.postDetails = postDetails;
    }
}
