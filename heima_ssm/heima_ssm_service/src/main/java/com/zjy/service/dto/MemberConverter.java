package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Member;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface MemberConverter {

    Member dtoToEntity(MemberDto memberDto);
    MemberDto entityToDto(Member member);
    List<MemberDto> listEntityToDto(List<Member> memberList);
    List<Member> listDtoToEntity(List<MemberDto> memberDtoList);
    Page<MemberDto> pageEntityToDto(Page<Member> page);

}