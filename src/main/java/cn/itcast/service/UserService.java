package cn.itcast.service;

import cn.itcast.domain.User;

import java.util.List;

public interface UserService {

    List<User> findAllUser();

    void addUser(User user, String[] roleIds);

    void delUser(int id);

    User login(String username, String password);
}
