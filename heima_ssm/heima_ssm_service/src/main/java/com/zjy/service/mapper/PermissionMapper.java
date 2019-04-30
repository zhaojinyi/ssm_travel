package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Permission;
import com.zjy.service.dto.PermissionDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service.mapper
 */
public interface PermissionMapper extends BaseMapper<Permission>{

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    List<PermissionDto> findPermissionByRoleId(String roleId);
}
