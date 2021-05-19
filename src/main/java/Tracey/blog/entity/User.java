package Tracey.blog.entity;



import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;


@Entity
public class User {
    @Id @GeneratedValue(generator = "system-uuid")
   @GenericGenerator(name = "system-uuid" ,strategy = "uuid")

    private String user_id;
    public String user_name;
    public String user_password;
    public String user_email;
    public String user_username;
    public Integer typeID;

    String getId(){ return user_id;};
    String getName(){ return user_name;};
    String getPassword(){return user_password;};
    String getUsername(){ return user_username;};
    String getEmail(){ return user_email;};
    Integer getTypeID(){ return typeID;};



}
