package com.zjy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.domain.Role;
import com.zjy.service.dto.PermissionDto;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.service
 */
public interface RoleService extends IService<Role>{


    List<PermissionDto> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] permissionIds);
}
