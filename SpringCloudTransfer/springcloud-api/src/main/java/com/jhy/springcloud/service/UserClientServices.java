package com.jhy.springcloud.service;

import com.jhy.springcloud.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Component
@FeignClient(value = "SPRINGCLOUD-PROVIDER-USER", fallbackFactory = UserClientServiceFallbackFactory.class)
public interface UserClientServices {

    @GetMapping("/user/get/{name}")
    public User queryByName(@PathVariable("name") String name);

    @GetMapping("/user/list")
    public List<User> queryAll();

    @PostMapping("/user/add")
    public boolean addUser(User user);
}
