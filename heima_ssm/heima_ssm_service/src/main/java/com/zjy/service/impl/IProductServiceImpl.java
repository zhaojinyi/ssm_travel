package com.zjy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjy.domain.Product;
import com.zjy.service.IProductService;
import com.zjy.service.mapper.ProductMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.service.impl
 */
@Service
@Transactional
public class IProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {



}
