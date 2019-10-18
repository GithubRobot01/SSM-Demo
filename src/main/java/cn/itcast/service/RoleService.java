package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAllRole();

    void addRole(Role role);
}
