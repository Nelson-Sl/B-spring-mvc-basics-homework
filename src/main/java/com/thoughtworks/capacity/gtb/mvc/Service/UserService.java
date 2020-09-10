package com.thoughtworks.capacity.gtb.mvc.Service;

import com.thoughtworks.capacity.gtb.mvc.Dao.UserDao;
import com.thoughtworks.capacity.gtb.mvc.domain.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    public void registerUser(User user) {
        UserDao.addUser(user);
    }
}
