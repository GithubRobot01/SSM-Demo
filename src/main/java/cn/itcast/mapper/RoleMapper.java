package cn.itcast.mapper;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {

    @Select("select * from sys_role")
    List<Role> findAllRole();

    @Insert("insert into sys_role values(null,#{roleName},#{roleDesc})")
    void addRole(Role role);

    @Select("SELECT * FROM sys_role sr,sys_user_role sur WHERE sur.roleId=sr.id AND sur.userId=#{uid}")
    List<Role> findRoleByUid(int uid);
}
