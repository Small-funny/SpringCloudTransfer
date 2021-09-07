package com.jhy.springcloud.controller;

import com.jhy.springcloud.pojo.User;
import com.jhy.springcloud.service.UserClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    private UserClientServices services;

    @RequestMapping("/consumer/user/get/{name}")
    public User get(@PathVariable("name") String name) {
        return this.services.queryByName(name);
    }

    @RequestMapping("consumer/user/list")
    public List<User> list() {
        return this.services.queryAll();
    }

    @RequestMapping("consumer/user/add")
    public boolean add(User user) {
        return this.services.addUser(user);
    }
}
