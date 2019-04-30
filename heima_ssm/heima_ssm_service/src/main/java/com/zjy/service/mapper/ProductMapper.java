package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Product;
import com.zjy.service.dto.ProductDto;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.dao
 */
public interface ProductMapper extends BaseMapper<Product>{

    @Select("select * from product where id=#{id}")
    ProductDto findById(String id);

}
