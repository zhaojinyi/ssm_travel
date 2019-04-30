package com.zjy.controller;

import com.zjy.domain.UserInfo;
import com.zjy.service.UserSerivce;
import com.zjy.service.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("user")
public class UsersController {

    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView();
        List<UserInfoDto> userInfoDtoList = userSerivce.userList();
        mv.addObject("userList", userInfoDtoList);
        mv.setViewName("user-list");
        return mv;

    }

    @RequestMapping("save.do")
    public String addUser(UserInfo userInfo) {
        userSerivce.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("findById.do")
    public ModelAndView showUser(String id){
        ModelAndView mv = new ModelAndView();

        UserInfoDto userInfoDto = userSerivce.showUser(id);
        mv.addObject("user", userInfoDto);
        mv.setViewName("user-show");
        return mv;
    }
}
