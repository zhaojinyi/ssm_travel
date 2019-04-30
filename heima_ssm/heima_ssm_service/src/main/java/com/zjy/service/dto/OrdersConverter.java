package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Member;
import com.zjy.domain.Orders;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface OrdersConverter {

    Orders dtoToEntity(OrdersDto ordersDto);
    OrdersDto entityToDto(Orders orders);
    List<OrdersDto> listEntityToDto(List<Orders> ordersList);
    List<Orders> listDtoToEntity(List<OrdersDto> ordersDtoList);
    Page<OrdersDto> pageEntityToDto(Page<Orders> page);

}