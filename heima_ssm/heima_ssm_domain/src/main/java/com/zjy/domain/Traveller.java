package com.zjy.domain;
//旅客

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Traveller {

    @TableId(type = IdType.AUTO)
    private String id;
    private String name;
    private String sex;
    private String phonenum;
    private Integer credentialstype;
    private String credentialsnum;
    private Integer travellertype;


}
