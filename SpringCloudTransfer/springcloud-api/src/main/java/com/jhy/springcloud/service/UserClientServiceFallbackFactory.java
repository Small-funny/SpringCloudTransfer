package com.jhy.springcloud.service;

import com.jhy.springcloud.pojo.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserClientServiceFallbackFactory implements FallbackFactory {
    @Override
    public Object create(Throwable throwable) {
        return new UserClientServices() {
            @Override
            public User queryByName(String name) {
                return new User().setUsername("没有对应信息" + name + " 降级处理").setClazz(-1).setClazz(-1);
            }

            @Override
            public List<User> queryAll() {
                return null;
            }

            @Override
            public boolean addUser(User user) {
                return false;
            }
        };
    }
}
