package Tracey.blog.service;


import Tracey.blog.business.PostManager;
import Tracey.blog.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin
@Controller
@RequestMapping(path = "/post")
public class PostController {

    @Autowired
    private PostManager postManager;

    @PostMapping(path = "/list")
    public @ResponseBody
    LinkedHashMap<String , Object> list(@RequestBody LinkedHashMap<String ,Object> params){
       LinkedHashMap<String ,Object> ret = new LinkedHashMap<>();
       ret.put(" code",1);
       ret.put("msg" ," successful");
       ret.put("data" , postManager.findAll());
       return ret;
    }

    @PostMapping(path = "/save")
    public @ResponseBody
    LinkedHashMap<String ,Object> save(@RequestBody Post post){
      LinkedHashMap<String ,Object> ret = new LinkedHashMap();
      Post post1 = postManager.save(post);
      ret.put("code",1);
      ret.put("msg","successful");
      ret.put("data" , post1);
      return ret;
    }


}
