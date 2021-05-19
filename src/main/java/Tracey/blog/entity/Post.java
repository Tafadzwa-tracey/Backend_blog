package Tracey.blog.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Post {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")

    private String post_id;
    private String  user_id;
    private String post_content;
    private String post_title;
    private String post_excerpt;
    private Integer comment_status;
    private Date post_modified;
    private Date post_date;
    private String slug;
    private String feature_image;
    private Integer post_status;

    public Date getPostDate(){ return post_date;}

    public Date getPostModified(){return post_modified;}

    public String getPostId(){ return post_id;}

    public String getUserId(){ return user_id;}

    public String getPostContent(){ return post_content;}

    public String getPostTitle() { return post_title;}

    public String getPostExcerpt() { return post_excerpt;}

    public Integer getCommentStatus(){ return comment_status;}


    public String getSlug(){ return slug;}

    public String getFeatureImage() { return feature_image;}

    public Integer getPostStatus() { return post_status;}



    public void setPostId(String post_id){
        this.post_id = post_id;
    }

    public void setPostContent(String post_content) {
        this.post_content = post_content;
    }

    public void setPostTitle(String post_title){
        this.post_title = post_title;
    }

    public void setPostExcerpt(String post_excerpt){
        this.post_excerpt = post_excerpt;
    }


    public void setSlug(String slug){
        this.slug = slug;
    }

    public void setFeatureImage( String feature_image){
        this.feature_image = feature_image;
    }


    public void setCommentStatus(Integer comment_status){
        this.comment_status = comment_status;
    }

    public void setPostDate( Date post_date){
        this.post_date = post_date;
    }

    public void setUserId( String user_id){
        this.user_id = user_id;
    }


    public void setPostModified(){
        this.post_modified = new Date();
    }

    public void setPostStatus(Integer post_status){
        this.post_status = post_status;
    }




}


