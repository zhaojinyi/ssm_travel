package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Role;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface RoleConverter {

    Role dtoToEntity(RoleDto roleDto);
    RoleDto entityToDto(Role role);
    List<RoleDto> listEntityToDto(List<Role> roles);
    List<Role> listDtoToEntity(List<RoleDto> roleDtos);
    Page<RoleDto> pageEntityToDto(Page<Role> page);

}