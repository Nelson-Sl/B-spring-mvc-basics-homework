package com.thoughtworks.capacity.gtb.mvc.Dao;

import com.thoughtworks.capacity.gtb.mvc.domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static List<User> currentUser = new ArrayList<>();

    public UserDao() {
        User newUser = new User("Nelson","Nelson","nelson@126.com");
        currentUser.add(newUser);
    }

    public static void addUser(User user) {
        currentUser.add(user);
    }
}
