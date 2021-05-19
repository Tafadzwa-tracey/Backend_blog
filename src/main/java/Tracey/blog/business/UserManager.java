package Tracey.blog.business;

import Tracey.blog.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserManager extends CrudRepository<User ,Integer> {
 @Query(value = "select * from user where user_username = ?1" ,nativeQuery = true)
 List<User> findByUserName(String user_username);

    default boolean userExist(String user_username){
        List<User> users = findByUserName(user_username);
        System.out.println("****** number of users***");
        System.out.println(users.size());
        System.out.println("****number of users****");
        if(users.size()==0){
            System.out.println("****number of users***");
            System.out.println("no user 1");
            System.out.println("***number of users***");
            return false;
        }
        else{
            for (User user : users) {
                System.out.println("****users present****");
                System.out.println(user.user_username);
                if (user.user_username.equals(user_username)) {
                    System.out.println("**** number of users****");
                    System.out.println("*** user found***");
                    return true;
                }
            }
        }
       return false;
    }
}
