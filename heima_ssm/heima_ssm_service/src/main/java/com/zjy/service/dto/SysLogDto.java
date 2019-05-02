package com.zjy.service.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.zjy.DateUtils;
import lombok.Data;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.domain
 */
@Data
@TableName(value = "syslog")
public class SysLogDto {

    @TableId(type = IdType.AUTO)
    private String id;
    private Date visittime;
    private String visittimestr;
    private String username;
    private String ip;
    private String url;
    private Long executiontime;
    private String method;

    public String getVisittimestr() {
        if(visittime != null) {
            visittimestr = DateUtils.date2Stirng(visittime, "yyyy-MM-dd HH:mm:ss");
        }
        return visittimestr;
    }

    public void setVisittimestr(String visittimestr) {
        this.visittimestr = visittimestr;
    }
}
