package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Permission;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface PermissionConverter {

    Permission dtoToEntity(PermissionDto permissionDto);
    PermissionDto entityToDto(Permission permission);
    List<PermissionDto> listEntityToDto(List<Permission> permissionList);
    List<Permission> listDtoToEntity(List<PermissionDto> permissionDtoList);
    Page<PermissionDto> pageEntityToDto(Page<Permission> page);

}