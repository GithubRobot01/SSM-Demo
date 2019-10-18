package cn.itcast.service.impl;

import cn.itcast.domain.User;
import cn.itcast.mapper.UserMapper;
import cn.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }

    public void addUser(User user, String[] roleIds) {
        userMapper.addUser(user);
        Long uid = user.getId();
        for (String roleId : roleIds) {
            userMapper.addUserAddRole(uid,roleId);
        }
    }

    public void delUser(int id) {
        //删除中间表数据
        //删除user表数据
        userMapper.delUserById(id);
    }

    public User login(String username, String password) {
        return userMapper.login(username,password);
    }

}
