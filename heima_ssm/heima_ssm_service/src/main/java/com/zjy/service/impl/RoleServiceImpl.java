package com.zjy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjy.domain.Role;
import com.zjy.service.RoleService;
import com.zjy.service.dto.PermissionDto;
import com.zjy.service.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.service.impl
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public void addPermissionToRole(String roleId, String[] permissionIds) {

        for (String permissionId:permissionIds) {
            System.out.println(roleId+"--------------"+permissionId);
            roleMapper.addPermissionToRole(roleId, permissionId);
        }

    }

    @Override
    public List<PermissionDto> findOtherPermission(String roleId) {
        return roleMapper.findOtherPermission(roleId);
    }
}