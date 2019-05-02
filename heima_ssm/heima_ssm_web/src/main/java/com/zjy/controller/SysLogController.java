package com.zjy.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zjy.domain.SysLog;
import com.zjy.service.SysLogService;
import com.zjy.service.dto.SysLogConverter;
import com.zjy.service.dto.SysLogDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/5/2
 * @Description: com.zjy.controller
 */
@Controller
@RequestMapping("/sysLog")
public class SysLogController {

    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private SysLogConverter sysLogConverter;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll () {
        ModelAndView mv = new ModelAndView();

        List<SysLog> sysLogList = sysLogService.list(new QueryWrapper<SysLog>().orderByDesc("visittime"));

        List<SysLogDto> sysLogDtoList = sysLogConverter.listEntityToDto(sysLogList);
        mv.addObject("sysLogs", sysLogDtoList);
        mv.setViewName("syslog-list");

        return mv;
    }

}
