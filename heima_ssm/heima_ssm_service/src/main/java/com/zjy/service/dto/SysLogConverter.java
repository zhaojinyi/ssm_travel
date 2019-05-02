package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.SysLog;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface SysLogConverter {

    SysLog dtoToEntity(SysLogDto sysLogDto);
    SysLogDto entityToDto(SysLog sysLog);
    List<SysLogDto> listEntityToDto(List<SysLog> sysLogList);
    List<SysLog> listDtoToEntity(List<SysLogDto> sysLogDtoList);
    Page<SysLogDto> pageEntityToDto(Page<SysLog> page);

}