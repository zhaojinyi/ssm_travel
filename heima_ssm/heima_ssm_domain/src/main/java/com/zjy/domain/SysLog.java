package com.zjy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.domain
 */
@Data
@TableName(value = "syslog")
public class SysLog {

    @TableId(type = IdType.AUTO)
    private String id;
    private Date visittime;
    private String username;
    private String ip;
    private String url;
    private Long executiontime;
    private String method;

}
