package com.jhy.springcloud.controller;

import com.jhy.springcloud.service.UserService;
import com.jhy.springcloud.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

//    @Autowired
//    private DiscoveryClient client;

    @PostMapping("/user/add")
    public boolean addDept(User user) {
        return userService.addUser(user);
    }

    @GetMapping("/user/get/{name}")
    public User get(@PathVariable("name") String name) {
        return userService.queryByName(name);
    }

    @GetMapping("/user/list")
    public List<User> queryAll() {
        return userService.queryAll();
    }

//    @GetMapping("user/discovery")
//    public Object discovery() {
//        List<String> services = client.getServices();
//        System.out.println("discovery=>service" + services);
//
//        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-USER");
//        for (ServiceInstance instance : instances) {
//            System.out.println(
//                    instance.getHost() + "\t" +
//                    instance.getPort() + "\t" +
//                    instance.getUri() + "\t" +
//                    instance.getServiceId()
//            );
//        }
//        return this.client;
//    }
}
