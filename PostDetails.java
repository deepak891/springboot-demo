package com.devlabs.springbootdemo;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "PostDetails")
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "created_on")
    private Date cratedOn;

    @Column(name = "created_by")
    private String createdBy;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "post_id")
    private Post post;

    public PostDetails() {
    }

    public PostDetails(String createdBy) {
        this.cratedOn = new Date();
        this.createdBy = createdBy;
    }

    public Date getCratedOn() {
        return cratedOn;
    }

    public void setCratedOn(Date cratedOn) {
        this.cratedOn = cratedOn;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    @Override
    public String toString() {
        return "PostDetails{" +
                "cratedOn=" + cratedOn +
                ", createdBy='" + createdBy + '\'' +

                '}';
    }
}
