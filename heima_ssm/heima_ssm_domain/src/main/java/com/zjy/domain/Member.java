package com.zjy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

//会员
@Data
public class Member {

    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private String nickname;
    private String phonenum;
    private String email;

}
