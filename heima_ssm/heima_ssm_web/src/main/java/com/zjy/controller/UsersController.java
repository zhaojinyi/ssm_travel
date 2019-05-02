package com.zjy.controller;

import com.zjy.domain.UserInfo;
import com.zjy.service.UserSerivce;
import com.zjy.service.dto.RoleDto;
import com.zjy.service.dto.UserInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("/user")
public class UsersController {

    @Autowired
    private UserSerivce userSerivce;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {

        ModelAndView mv = new ModelAndView();
        List<UserInfoDto> userInfoDtoList = userSerivce.userList();
        mv.addObject("userList", userInfoDtoList);
        mv.setViewName("user-list");
        return mv;

    }

    @RequestMapping("/save.do")
    public String addUser(UserInfo userInfo) {
        userSerivce.save(userInfo);
        return "redirect:findAll.do";
    }

    @RequestMapping("/findById.do")
    public ModelAndView showUser(String id){
        ModelAndView mv = new ModelAndView();

        UserInfoDto userInfoDto = userSerivce.showUser(id);
        mv.addObject("user", userInfoDto);
        mv.setViewName("user-show");
        return mv;
    }

    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole (@RequestParam(name="id", required = true) String userId) {
        //  根据用户id查出用户信息
        UserInfoDto userInfoDto = userSerivce.showUser(userId);

        //  根据用户id 查询出用户可以添加的角色
        ModelAndView mv = new ModelAndView();
        List<RoleDto> roleDtoList = userSerivce.findOtherRoles(userId);
        mv.addObject("user", userInfoDto);
        mv.addObject("roleList", roleDtoList);
        mv.setViewName("user-role-add");
        return mv;
    }

    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
        userSerivce.addRoleToUser(userId, roleIds);

        return "redirect:findAll.do";

    }
}
