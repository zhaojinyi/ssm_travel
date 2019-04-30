package com.zjy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.domain
 */
@Data
public class UserInfo {

    @TableId(type = IdType.AUTO)
    private String id;
    private String username;
    private String email;
    private String password;
    private String phonenum;
    private int status;

}
