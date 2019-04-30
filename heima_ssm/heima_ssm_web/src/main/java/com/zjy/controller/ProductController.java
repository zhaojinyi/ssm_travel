package com.zjy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.domain.Product;
import com.zjy.service.IProductService;
import com.zjy.service.dto.ProductConverter;
import com.zjy.service.dto.ProductDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @Autowired
    private ProductConverter productConverter;

    @RequestMapping("save.do")
    public String save(ProductDto productDto) {
        Product product = productConverter.dtoToEntity(productDto);
        System.out.println(product);
        productService.save(product);
        return "redirect:findAll.do";
    }

    // 查询全部产品
    @RequestMapping("findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> productList = productService.list(new QueryWrapper<Product>());
        List<ProductDto> productDtoList = productConverter.listEntityToDto(productList);
        mv.addObject("productList", productDtoList);
        mv.setViewName("product-list");

        return mv;
    }

}
