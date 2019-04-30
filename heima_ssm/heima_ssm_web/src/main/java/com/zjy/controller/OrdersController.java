package com.zjy.controller;

import com.github.pagehelper.PageInfo;
import com.zjy.service.OrdersService;
import com.zjy.service.dto.OrdersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("orders")
public class OrdersController {

    @Autowired
    private OrdersService ordersService;


    // 查询全部产品  未分页
//    @RequestMapping("findAll.do")
//    public ModelAndView findAll() throws Exception {
//
//        ModelAndView mv = new ModelAndView();
//        List<OrdersDto> ordersDtoList = ordersService.findAll();
//
//        mv.addObject("ordersList", ordersDtoList);
//        mv.setViewName("orders-list");
//
//        return mv;
//    }

    @RequestMapping("findAll.do")
    @Secured("ROLE_ADMIN")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") int page, @RequestParam(name="size", required = true, defaultValue = "4")int size) throws Exception {

        ModelAndView mv = new ModelAndView();
        List<OrdersDto> ordersDtoList = ordersService.findAll(page, size);
        //  pageInfo  就是一个分页bean
        PageInfo pageInfo = new PageInfo(ordersDtoList);

        mv.addObject("pageInfo", pageInfo);

        mv.setViewName("orders-page-list");
        return mv;
    }

    @RequestMapping("findById")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String orderId) {
        ModelAndView mv = new ModelAndView();

        OrdersDto orders = ordersService.findById(orderId);
        mv.addObject("orders", orders);
        mv.setViewName("orders-show");
        return mv;
    }



}
