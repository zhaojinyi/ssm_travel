package com.zjy.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: 商品信息
 */
@Data
public class Product {

    @TableId(type = IdType.AUTO)
    private String id; // 主键
    private String productnum; // 编号 唯一
    private String productname; // 名称
    private String cityname; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departuretime; // 出发时间
    private double productprice; // 产品价格
    private String productdesc; // 产品描述
    private Integer productstatus; // 状态 0 关闭 1 开启

}
