package com.zjy.service.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zjy.domain.Member;
import com.zjy.service.dto.MemberDto;
import org.apache.ibatis.annotations.Select;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/27
 * @Description: com.zjy.dao
 */
public interface MemberMapper extends BaseMapper<Member>{

    @Select("select * from member where id=#{id}")
    MemberDto findById(String id);

}
