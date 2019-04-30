package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Orders;
import com.zjy.domain.Product;
import com.zjy.service.dto.MemberDto;
import com.zjy.service.dto.OrdersDto;
import com.zjy.service.dto.ProductDto;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.dao
 */
public interface OrdersMapper extends BaseMapper<Orders>{

    @Select("select * from orders")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "ordernum", column = "ordernum"),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "orderstatus", column = "orderstatus"),
            @Result(property = "peoplecount", column = "peoplecount"),
            @Result(property = "paytype", column = "paytype"),
            @Result(property = "orderdesc", column = "orderdesc"),
            @Result(property = "product", column = "productId", javaType = Product.class,one=@One(select = "com.zjy.service.mapper.ProductMapper.findById"))
    })
    public List<OrdersDto> findAll();

    @Select("select * from orders where id=#{orderId}")
    @Results({
            @Result(id=true, property = "id", column = "id"),
            @Result(property = "ordernum", column = "ordernum"),
            @Result(property = "ordertime", column = "ordertime"),
            @Result(property = "orderstatus", column = "orderstatus"),
            @Result(property = "peoplecount", column = "peoplecount"),
            @Result(property = "paytype", column = "paytype"),
            @Result(property = "orderdesc", column = "orderdesc"),
            @Result(property = "product", column = "productId", javaType = ProductDto.class,one=@One(select = "com.zjy.service.mapper.ProductMapper.findById")),
            @Result(property = "member", column = "memberId", javaType = MemberDto.class, one=@One(select = "com.zjy.service.mapper.MemberMapper.findById")),
            @Result(property = "travellers", column = "id", javaType = java.util.List.class, many=@Many(select = "com.zjy.service.mapper.TravellerMapper.findByOrdersId"))
    })
    public OrdersDto findById(String orderId);

}
