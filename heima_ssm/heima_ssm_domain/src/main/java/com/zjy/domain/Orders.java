package com.zjy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;
import java.util.List;

//订单
@Data
public class Orders {

    @TableId(type = IdType.AUTO)
    private String id;

    private String ordernum;
    private Date ordertime;
    private int orderstatus;
    private int peoplecount;
    private Integer paytype;
    private String orderdesc;

}
