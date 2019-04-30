package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Role;
import com.zjy.service.dto.PermissionDto;
import com.zjy.service.dto.RoleDto;
import org.apache.ibatis.annotations.*;

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

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<PermissionDto> findOtherPermission(String roleId);

    @Insert("insert into role_permission(roleId, permissionId) values(#{roleId}, #{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
