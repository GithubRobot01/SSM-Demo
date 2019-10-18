package cn.itcast.service.impl;


import cn.itcast.domain.Role;
import cn.itcast.mapper.RoleMapper;
import cn.itcast.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    public List<Role> findAllRole() {
        return roleMapper.findAllRole();
    }

    public void addRole(Role role) {
        roleMapper.addRole(role);
    }
}
