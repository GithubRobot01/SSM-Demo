package cn.itcast.mapper;

import cn.itcast.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Select("select * from sys_user")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",
                    column = "id",
                    javaType = List.class,
                    many = @Many(select = "cn.itcast.mapper.RoleMapper.findRoleByUid")
            )
    })
    List<User> findAllUser();

    @Insert("insert into sys_user values(null,#{username},#{email},#{password},#{phoneNum})")
    @Options(useGeneratedKeys = true,keyColumn = "id")
    void addUser(User user);

    @Insert("insert into sys_user_role values(#{arg0},#{arg1})")
    //void addUserAddRole(@Param("uid") Long uid,@Param("roleId") String roleId);
    void addUserAddRole(Long uid,String roleId);

    @Delete("delete from sys_user_role where userId = #{id}")
    void delUserAndRole(int id);

    @Delete("delete from sys_user where id = #{id}")
    void delUserById(int id);

    @Select("select * from sys_user where username=#{param1} and password=#{param2}")
    User login(String username, String password);
}
