package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.UserInfo;
import com.zjy.service.dto.RoleDto;
import com.zjy.service.dto.UserInfoDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service.mapper
 */
public interface UserInfoMapper extends BaseMapper<UserInfo> {

    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phonenum", column = "phonenum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many=@Many(select = "com.zjy.service.mapper.RoleMapper.findRoleByUserId")),
    })
    UserInfoDto findByUsername(String username);

    @Select("select * from users")
    List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phonenum,status) values(#{email},#{username},#{password},#{phonenum},#{status})")
    void save(UserInfo userInfo);

    @Select("select * from users where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "username", column = "username"),
            @Result(property = "email", column = "email"),
            @Result(property = "password", column = "password"),
            @Result(property = "phonenum", column = "phonenum"),
            @Result(property = "status", column = "status"),
            @Result(property = "roles", column = "id", javaType = java.util.List.class, many=@Many(select = "com.zjy.service.mapper.RoleMapper.findRoleByUserId")),
    })
    UserInfoDto showUser(String id);

    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<RoleDto> findOtherRoles(String userId);

    @Insert("insert into users_role(userId, roleId) values(#{userId}, #{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}
