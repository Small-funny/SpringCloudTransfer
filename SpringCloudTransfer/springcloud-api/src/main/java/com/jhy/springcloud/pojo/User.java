package com.jhy.springcloud.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class User implements Serializable {

    private String username;  // 主键
    private int age;

    private int clazz;

    public User(String name) {
        this.username = name;
    }
}
