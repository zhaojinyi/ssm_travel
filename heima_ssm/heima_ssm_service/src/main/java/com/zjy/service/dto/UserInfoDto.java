package com.zjy.service.dto;

import lombok.Data;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service.dto
 */
@Data
public class UserInfoDto {

    private String id;
    private String username;
    private String email;
    private String password;
    private String phonenum;
    private int status;
    private String statusstr;
    private List<RoleDto> roles;

    public String getStatusstr() {
        if(status == 0) {
            statusstr = "未开启";
        }else if(status == 1){
            statusstr = "开启";
        }
        return statusstr;
    }

    public void setStatusstr(String statusstr) {
        this.statusstr = statusstr;
    }
}
