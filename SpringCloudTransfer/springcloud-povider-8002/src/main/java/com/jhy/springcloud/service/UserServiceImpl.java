package com.jhy.springcloud.service;

import com.jhy.springcloud.dao.UserDao;
import com.jhy.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserDao userDao;

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public User queryByName(String name) {
        return userDao.queryByName(name);
    }

    public List<User> queryAll() {
        return userDao.queryAll();
    }
}
