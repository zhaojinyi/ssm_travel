package com.zjy.service.dto;

import com.zjy.DateUtils;
import com.zjy.domain.Traveller;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Data
public class OrdersDto {

    private String id;
    private String ordernum;
    private Date ordertime;
    private String ordertimestr;
    private int orderstatus;
    private String orderstatusstr;
    private int peoplecount;
    private ProductDto product;
    private List<Traveller> travellers;
    private MemberDto member;
    private Integer paytype;
    private String paytypestr;
    private String orderdesc;

    public String getOrdertimestr() {
        if(ordertime != null) {
            ordertimestr = DateUtils.date2Stirng(ordertime, "yyyy-MM-dd HH:mm");
        }
        return ordertimestr;
    }

    public String getPaytypestr() {
        if(paytype == 0){
            paytypestr = "支付宝";
        }else if(paytype == 1){
            paytypestr = "微信";
        }else if(paytype == 2){
            paytypestr = "其他";
        }
        return paytypestr;
    }

    public void setPaytypestr(String paytypestr) {
        this.paytypestr = paytypestr;
    }

    public void setOrdertimestr(String ordertimestr) {
        this.ordertimestr = ordertimestr;
    }

    public String getOrderstatusstr() {
        if(orderstatus == 0) {
            orderstatusstr = "未支付";
        }else if(orderstatus == 1){
            orderstatusstr = "已支付";
        }
        return orderstatusstr;
    }

    public void setOrderstatusstr(String orderstatusstr) {
        this.orderstatusstr = orderstatusstr;
    }
}
