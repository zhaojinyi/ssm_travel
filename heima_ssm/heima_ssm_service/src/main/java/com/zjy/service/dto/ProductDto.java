package com.zjy.service.dto;

import com.zjy.DateUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Data
public class ProductDto {

    private String id; // 主键
    private String productnum; // 编号 唯一
    private String productname; // 名称
    private String cityname; // 出发城市
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departuretime; // 出发时间
    private double productprice; // 产品价格
    private String productdesc; // 产品描述
    private Integer productstatus; // 状态 0 关闭 1 开启

    private String productstatusstr;
    private String departuretimestr;

    public String getProductstatusstr() {
        if(productstatus == 1) {
            productstatusstr = "开启";
        } else{
            productstatusstr = "关闭";
        }
        return productstatusstr;
    }

    public void setProductstatusstr(String productstatusstr) {
        this.productstatusstr = productstatusstr;
    }

    public String getDeparturetimestr() {
        if(departuretime != null) {
            departuretimestr = DateUtils.date2Stirng(departuretime, "yyyy-MM-dd HH:mm:ss");
        }
        return departuretimestr;
    }

    public void setDeparturetimestr(String departuretimestr) {
        this.departuretimestr = departuretimestr;
    }
}
