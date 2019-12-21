package com.offcn.service;

import com.offcn.pojo.User;

import java.util.List;

public interface UserService {
    List<User> finAll();

    User findOne(Integer id);

    void save(User user);

    void update(User user);

    void deleteById(Integer id);
}
