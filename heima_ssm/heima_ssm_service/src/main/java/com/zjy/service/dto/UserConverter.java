package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.UserInfo;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface UserConverter {

    UserInfo dtoToEntity(UserInfoDto userInfoDto);
    UserInfoDto entityToDto(UserInfo userInfo);
    List<UserInfoDto> listEntityToDto(List<UserInfo> userInfos);
    List<UserInfo> listDtoToEntity(List<UserInfoDto> userInfoDtos);
    Page<UserInfoDto> pageEntityToDto(Page<UserInfo> page);

}