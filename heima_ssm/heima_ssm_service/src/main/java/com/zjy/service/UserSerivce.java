package com.zjy.service;

import com.zjy.domain.UserInfo;
import com.zjy.service.dto.UserInfoDto;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service
 */
public interface UserSerivce extends UserDetailsService {

    List<UserInfoDto> userList();

    void save(UserInfo userInfo);

    UserInfoDto showUser(String id);
}
