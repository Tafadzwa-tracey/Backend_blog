package Tracey.blog.service;

import Tracey.blog.business.UserManager;
import Tracey.blog.entity.User;
import org.apache.catalina.filters.ExpiresFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.security.provider.MD5;
import sun.security.util.Password;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(path = "/user")
public class UserController {
    @Autowired
    private UserManager userManager;
    private MD5 password;
    @PostMapping(path = "/register")
    public @ResponseBody LinkedHashMap<String ,Object> register(@RequestBody LinkedHashMap<String ,Object> params) throws NoSuchAlgorithmException{
        User user = new User();
        System.out.println(params);
        user.user_name = (String) params.get("user_name");
        user.user_username = (String) params.get("user_username");
        user.user_email = (String) params.get("user_email");
        user.user_password =getMD5((String)params.get("user_password"));
        user.typeID = (Integer)params.get("typeID");

        LinkedHashMap<String,Object> ret = new LinkedHashMap<>();
        User user1 =new User();
        if(!userManager.userExist(user.user_username)){
            user1 = userManager.save(user);
            ret.put("code",1);
            ret.put("msg","Successful");
        }
       else{
            ret.put("code",0);
            ret.put("msg","UserName already exist try again");
      }
        ret.put("data" ,user1);
        return ret;
    }

    @PatchMapping(path = "/login")
    public @ResponseBody LinkedHashMap<String,Object> login(@RequestBody LinkedHashMap<String,Object> params) throws NoSuchAlgorithmException{
        LinkedHashMap<String,Object> ret = new LinkedHashMap();
        String sql = "SELECT * FROM user WHERE user_username:tracey AND password='20munashe";

        List<User> userList = userManager.findByUserName((String)params.get("user_username"));
        for (User user : userList) {
            if (user.user_username.equals(params.get("user_username"))) {
                String password = getMD5((String) params.get("user_password"));
                if (password.equals(user.user_password)) {
                    ret.put("code", 1);
                    ret.put("msg", "Successful");
                    ret.put("data", user);
                    return ret;
                } else {
                    ret.put("code", 0);
                    ret.put("msg", "Wrong password");
                    ret.put("data", null);
                    return ret;
                }
            }
        }
        ret.put("code",0);
        ret.put("msg","failed username does not exist");
        ret.put("data",null);
        return ret;
    }

    @PostMapping (path = "/list")
    public @ResponseBody LinkedHashMap<String ,Object> list(){
        LinkedHashMap<String ,Object> ret = new LinkedHashMap<>();
        ret.put("code",1);
        ret.put("data",userManager.findAll());
        ret.put("msg" ,"Successful");
        ret.put("count", userManager.count());
        return ret;

    }

    public String getMD5(String data) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");

        messageDigest.update(data.getBytes());
        byte[] digest = messageDigest.digest();
        StringBuilder sb = new StringBuilder();
        for(byte b : digest){
            sb.append(Integer.toHexString(b & 0xff));
        }
        return sb.toString();
    }


}
