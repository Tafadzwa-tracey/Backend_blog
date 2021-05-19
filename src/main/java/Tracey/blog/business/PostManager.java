package Tracey.blog.business;

import Tracey.blog.entity.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostManager extends CrudRepository<Post,Integer>{
}
