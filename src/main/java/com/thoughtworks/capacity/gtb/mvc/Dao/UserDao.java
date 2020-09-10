package com.thoughtworks.capacity.gtb.mvc.Dao;

import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDao {
    private List<User> currentUser = new ArrayList<>();

    public UserDao() {
        User newUser = User.builder().id(1).username("Nelson").password("Nelson").email("nelson@126.com").build();
        currentUser.add(newUser);
    }

    public void addUser(User user) {
        user.setId(currentUser.size() + 1);
        currentUser.add(user);
    }

    public User loginUser(String username, String password) {
        for(User registeredUser: currentUser) {
            if(username.equals(registeredUser.getUsername())  && password.equals(registeredUser.getPassword())) {
                return registeredUser;
            }
        }
        return null;
    }
}
