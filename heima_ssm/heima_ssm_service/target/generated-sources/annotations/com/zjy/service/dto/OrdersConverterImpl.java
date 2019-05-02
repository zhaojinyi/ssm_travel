package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Orders;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-02T13:20:57+0800",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class OrdersConverterImpl implements OrdersConverter {

    @Override
    public Orders dtoToEntity(OrdersDto ordersDto) {
        if ( ordersDto == null ) {
            return null;
        }

        Orders orders = new Orders();

        orders.setId( ordersDto.getId() );
        orders.setOrdernum( ordersDto.getOrdernum() );
        orders.setOrdertime( ordersDto.getOrdertime() );
        orders.setOrderstatus( ordersDto.getOrderstatus() );
        orders.setPeoplecount( ordersDto.getPeoplecount() );
        orders.setPaytype( ordersDto.getPaytype() );
        orders.setOrderdesc( ordersDto.getOrderdesc() );

        return orders;
    }

    @Override
    public OrdersDto entityToDto(Orders orders) {
        if ( orders == null ) {
            return null;
        }

        OrdersDto ordersDto = new OrdersDto();

        ordersDto.setId( orders.getId() );
        ordersDto.setOrdernum( orders.getOrdernum() );
        ordersDto.setOrdertime( orders.getOrdertime() );
        ordersDto.setOrderstatus( orders.getOrderstatus() );
        ordersDto.setPeoplecount( orders.getPeoplecount() );
        ordersDto.setPaytype( orders.getPaytype() );
        ordersDto.setOrderdesc( orders.getOrderdesc() );

        return ordersDto;
    }

    @Override
    public List<OrdersDto> listEntityToDto(List<Orders> ordersList) {
        if ( ordersList == null ) {
            return null;
        }

        List<OrdersDto> list = new ArrayList<OrdersDto>();
        for ( Orders orders : ordersList ) {
            list.add( entityToDto( orders ) );
        }

        return list;
    }

    @Override
    public List<Orders> listDtoToEntity(List<OrdersDto> ordersDtoList) {
        if ( ordersDtoList == null ) {
            return null;
        }

        List<Orders> list = new ArrayList<Orders>();
        for ( OrdersDto ordersDto : ordersDtoList ) {
            list.add( dtoToEntity( ordersDto ) );
        }

        return list;
    }

    @Override
    public Page<OrdersDto> pageEntityToDto(Page<Orders> page) {
        if ( page == null ) {
            return null;
        }

        Page<OrdersDto> page1 = new Page<OrdersDto>();

        page1.setPages( page.getPages() );
        List<OrdersDto> list = listEntityToDto( page.getRecords() );
        if ( list != null ) {
            page1.setRecords( list );
        }
        page1.setTotal( page.getTotal() );
        page1.setSize( page.getSize() );
        page1.setCurrent( page.getCurrent() );
        page1.setSearchCount( page.isSearchCount() );

        return page1;
    }
}
