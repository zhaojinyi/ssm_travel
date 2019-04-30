package com.zjy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.zjy.domain.Orders;
import com.zjy.service.OrdersService;
import com.zjy.service.dto.OrdersDto;
import com.zjy.service.mapper.OrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.service.impl
 */
@Service
@Transactional
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<OrdersDto> findAll(int page, int size) {
        // 参数pageNum 是页码，。 pageSize 代表每页显示
        PageHelper.startPage(page, size);
        return ordersMapper.findAll();
    }

    @Override
    public OrdersDto findById(String orderId) {

        return ordersMapper.findById(orderId);
    }
}
