package com.jhy.springcloud.controller;

import com.jhy.springcloud.service.UserService;
import com.jhy.springcloud.pojo.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
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

    @HystrixCommand(fallbackMethod = "hystrixGet")
    @GetMapping("/user/get/{name}")
    public User get(@PathVariable("name") String name) {
        User user = userService.queryByName(name);
        if (user == null) {
            throw new RuntimeException("用户不存在 error");
        }
        return user;
    }

    @GetMapping("/user/list")
    public List<User> queryAll() {
        return userService.queryAll();
    }

    public User hystrixGet(@PathVariable("name") String name) {
        return new User().setUsername(name).setClazz(-1).setAge(23);
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
