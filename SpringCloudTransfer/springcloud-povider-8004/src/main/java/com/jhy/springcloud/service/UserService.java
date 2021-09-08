package com.jhy.springcloud.service;

import com.jhy.springcloud.pojo.User;

import java.util.List;

public interface UserService {

    public boolean addUser(User user);

    public User queryByName(String name);

    public List<User> queryAll();
}
