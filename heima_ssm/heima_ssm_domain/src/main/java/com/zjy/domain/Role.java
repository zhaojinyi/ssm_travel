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
public class Role {

    @TableId(type = IdType.AUTO)
    private String id;
    private String rolename;
    private String roledesc;

}
