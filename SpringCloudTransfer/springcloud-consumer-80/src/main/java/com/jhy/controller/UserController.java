package com.jhy.controller;

import com.jhy.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private RestTemplate restTemplate;

    private static final String REST_URL_PREFIX = "http://localhost:8002";

    @RequestMapping("/consumer/user/get/{name}")
    public User get(@PathVariable("name") String name) {
        return restTemplate.getForObject(REST_URL_PREFIX + "/user/get/" + name, User.class);
    }

    @RequestMapping("consumer/user/list")
    public List<User> list() {
        return restTemplate.getForObject(REST_URL_PREFIX + "user/list", List.class);
    }

    @RequestMapping("consumer/user/add")
    public boolean add(User user) {
        return restTemplate.postForObject(REST_URL_PREFIX + "user/add", user, Boolean.class);
    }
}
