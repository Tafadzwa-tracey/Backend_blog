package Tracey.blog.service;

import Tracey.blog.business.CommentManager;
import Tracey.blog.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;

@CrossOrigin
@Controller
@RequestMapping(path = "/comment")
public class CommentController {

    @Autowired
    private CommentManager commentManager;

    @PostMapping(path = "/list")
    public @ResponseBody
    LinkedHashMap<String , Object> list(@RequestBody LinkedHashMap<String ,Object> params){
        LinkedHashMap<String ,Object> ret = new LinkedHashMap<>();
        ret.put(" code",1);
        ret.put("msg" ," successful");
        ret.put("data" , commentManager.findAll());
        return ret;
    }

    @PostMapping(path = "/save")
    public @ResponseBody
    LinkedHashMap<String ,Object> save(@RequestBody Comment comment){
        LinkedHashMap<String ,Object> ret = new LinkedHashMap();
        Comment comment1 = commentManager.save(comment);
        ret.put("code",1);
        ret.put("msg","successful");
        ret.put("data" , comment1);
        return ret;
    }

}
