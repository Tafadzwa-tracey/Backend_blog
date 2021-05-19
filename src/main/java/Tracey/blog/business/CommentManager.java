package Tracey.blog.business;

import Tracey.blog.entity.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentManager extends CrudRepository<Comment,Integer> {
}