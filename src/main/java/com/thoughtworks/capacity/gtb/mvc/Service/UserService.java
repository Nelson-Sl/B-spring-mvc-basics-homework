package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Dao.UserDao;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public void registerUser(User user) {
        this.userDao.addUser(user);
    }

    public User loginUser(String username, String password) {
        User loginUser = this.userDao.loginUser(username, password);
        return loginUser;
    }
}
