package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Traveller;
import com.zjy.service.dto.TravellerDto;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.dao
 */
public interface TravellerMapper extends BaseMapper<Traveller>{

    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<TravellerDto> findByOrdersId(String ordersId);

}
