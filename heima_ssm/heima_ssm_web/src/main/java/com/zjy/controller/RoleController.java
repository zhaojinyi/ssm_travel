package com.zjy.controller;

import com.zjy.domain.Role;
import com.zjy.service.RoleService;
import com.zjy.service.dto.RoleConverter;
import com.zjy.service.dto.RoleDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleConverter roleConverter;

    @RequestMapping("findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<RoleDto> roleDtoList = roleConverter.listEntityToDto(roleService.list());
        mv.addObject("roleList", roleDtoList);
        mv.setViewName("role-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String addRole(RoleDto roleDto) {
        Role role = roleConverter.dtoToEntity(roleDto);
        roleService.save(role);
        return "redirect:findAll.do";
    }
}
