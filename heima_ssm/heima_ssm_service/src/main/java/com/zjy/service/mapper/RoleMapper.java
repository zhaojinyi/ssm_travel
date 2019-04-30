package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Role;
import com.zjy.service.dto.RoleDto;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service.mapper
 */
public interface RoleMapper extends BaseMapper<Role>{

    @Select("select * from role where id in (select roleid from users_role where userid=#{userId})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "rolename", column = "rolename"),
            @Result(property = "roledesc", column = "roledesc"),
            @Result(property = "rolename", column = "rolename"),
            @Result(property = "permissions", column = "id", javaType = java.util.List.class, many = @Many(select = "com.zjy.service.mapper.PermissionMapper.findPermissionByRoleId"))
    })
    List<RoleDto> findRoleByUserId(String userId);

}
