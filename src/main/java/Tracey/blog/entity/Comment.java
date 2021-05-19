package Tracey.blog.entity;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.stereotype.Controller;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Comment {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")

    private String comment_post_id;
    private String  comment_author;
    private String comment_author_email;
    private String comment_content;
    private Integer comment_approved;
    private Date comment_date;
    private String user_id;
    private String post_id;

    public  String getPostId(){ return post_id;}

    public Date getCommentDate(){ return comment_date;}

    public String getCommentPostId(){ return comment_post_id;}

    public String getCommentAuthor(){ return comment_author;}

    public String getCommentAuthorEmail(){ return comment_author_email;}

    public String getCommentContent() { return comment_content;}

    public Integer getCommentApproved(){ return comment_approved;}

    public String user_id(){ return user_id;}

    public void setPostId(String post_id) {
        this.post_id = post_id;
    }

    public void setCommentDate(Date comment_date) { this.comment_date = comment_date;}

    public void setCommentPostId(String comment_post_id){
        this.comment_post_id = comment_post_id;
    }

    public void setCommentAuthor(String comment_author){this.comment_author = comment_author;}

    public void setCommentAuthor_Email(String comment_author_email){this.comment_author_email = comment_author_email;}

    public void setCommentContent(String comment_content){ this.comment_content = comment_content;}

    public void setCommentApproved( Integer comment_approved){ this.comment_approved = comment_approved;}

    public void setUserId(String user_id){ this.user_id = user_id;}










}
