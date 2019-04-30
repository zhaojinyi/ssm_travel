package com.zjy.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zjy.domain.Role;
import com.zjy.service.RoleService;
import com.zjy.service.mapper.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.service.impl
 */
@Service
@Transactional
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {


}