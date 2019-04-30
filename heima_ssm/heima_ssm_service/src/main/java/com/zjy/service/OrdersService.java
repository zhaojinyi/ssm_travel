package com.zjy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zjy.domain.Orders;
import com.zjy.service.dto.OrdersDto;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.service
 */
public interface OrdersService extends IService<Orders>{

    public List<OrdersDto> findAll(int page, int size);

    public OrdersDto findById(String orderId);

}
