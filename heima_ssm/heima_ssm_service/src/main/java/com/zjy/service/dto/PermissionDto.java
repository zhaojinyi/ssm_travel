package com.zjy.service.dto;

import lombok.Data;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service.dto
 */
@Data
public class PermissionDto {

    private String id;
    private String permissionname;
    private String url;
    private List<RoleDto> roles;

}
