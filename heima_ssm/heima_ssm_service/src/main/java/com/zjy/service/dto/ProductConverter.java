package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Product;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface ProductConverter {

    Product dtoToEntity(ProductDto productDto);
    ProductDto entityToDto(Product product);
    List<ProductDto> listEntityToDto(List<Product> productList);
    List<Product> listDtoToEntity(List<ProductDto> productDtoList);
    Page<ProductDto> pageEntityToDto(Page<Product> page);

}