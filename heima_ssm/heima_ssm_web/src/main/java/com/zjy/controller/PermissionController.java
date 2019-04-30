package com.zjy.controller;

import com.zjy.domain.Permission;
import com.zjy.service.PermissionService;
import com.zjy.service.dto.PermissionConverter;
import com.zjy.service.dto.PermissionDto;
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
@RequestMapping("/permission")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private PermissionConverter permissionConverter;

    @RequestMapping("findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<PermissionDto> permissionDtoList = permissionConverter.listEntityToDto(permissionService.list());

        mv.addObject("permissionList", permissionDtoList);
        mv.setViewName("permission-list");
        return mv;
    }

    @RequestMapping("save.do")
    public String addPermission(PermissionDto permissionDto){
        Permission permission = permissionConverter.dtoToEntity(permissionDto);
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
}
