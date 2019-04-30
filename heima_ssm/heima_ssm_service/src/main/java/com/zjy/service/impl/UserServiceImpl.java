package com.zjy.service.impl;

import com.zjy.domain.UserInfo;
import com.zjy.service.UserSerivce;
import com.zjy.service.dto.RoleDto;
import com.zjy.service.dto.UserConverter;
import com.zjy.service.dto.UserInfoDto;
import com.zjy.service.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/29
 * @Description: com.zjy.service.impl
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserSerivce{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println(12434);
        UserInfoDto userInfo = userInfoMapper.findByUsername(username);
        System.out.println(userInfo);
        User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));

        return user;
    }
    //作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<RoleDto> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (RoleDto role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRolename()));
        }
        return list;
    }

    @Override
    public List<UserInfoDto> userList() {
        return userConverter.listEntityToDto(userInfoMapper.findAll());
    }

    @Override
    public void save(UserInfo userInfo) {
        // 对密码加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userInfoMapper.save(userInfo);
    }

    @Override
    public UserInfoDto showUser(String id) {
        return userInfoMapper.showUser(id);
    }
}
