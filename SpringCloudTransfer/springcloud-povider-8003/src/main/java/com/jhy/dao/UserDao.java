package com.jhy.dao;

import com.jhy.springcloud.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserDao {

    public boolean addUser(User user);

    public User queryByName(String name);

    public List<User> queryAll();
}
