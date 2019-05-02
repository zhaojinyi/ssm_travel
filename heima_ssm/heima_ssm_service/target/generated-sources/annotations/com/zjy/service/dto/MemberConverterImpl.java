package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Member;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-02T13:20:57+0800",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class MemberConverterImpl implements MemberConverter {

    @Override
    public Member dtoToEntity(MemberDto memberDto) {
        if ( memberDto == null ) {
            return null;
        }

        Member member = new Member();

        member.setId( memberDto.getId() );
        member.setName( memberDto.getName() );
        member.setNickname( memberDto.getNickname() );
        member.setPhonenum( memberDto.getPhonenum() );
        member.setEmail( memberDto.getEmail() );

        return member;
    }

    @Override
    public MemberDto entityToDto(Member member) {
        if ( member == null ) {
            return null;
        }

        MemberDto memberDto = new MemberDto();

        memberDto.setId( member.getId() );
        memberDto.setName( member.getName() );
        memberDto.setNickname( member.getNickname() );
        memberDto.setPhonenum( member.getPhonenum() );
        memberDto.setEmail( member.getEmail() );

        return memberDto;
    }

    @Override
    public List<MemberDto> listEntityToDto(List<Member> memberList) {
        if ( memberList == null ) {
            return null;
        }

        List<MemberDto> list = new ArrayList<MemberDto>();
        for ( Member member : memberList ) {
            list.add( entityToDto( member ) );
        }

        return list;
    }

    @Override
    public List<Member> listDtoToEntity(List<MemberDto> memberDtoList) {
        if ( memberDtoList == null ) {
            return null;
        }

        List<Member> list = new ArrayList<Member>();
        for ( MemberDto memberDto : memberDtoList ) {
            list.add( dtoToEntity( memberDto ) );
        }

        return list;
    }

    @Override
    public Page<MemberDto> pageEntityToDto(Page<Member> page) {
        if ( page == null ) {
            return null;
        }

        Page<MemberDto> page1 = new Page<MemberDto>();

        page1.setPages( page.getPages() );
        List<MemberDto> list = listEntityToDto( page.getRecords() );
        if ( list != null ) {
            page1.setRecords( list );
        }
        page1.setTotal( page.getTotal() );
        page1.setSize( page.getSize() );
        page1.setCurrent( page.getCurrent() );
        page1.setSearchCount( page.isSearchCount() );

        return page1;
    }
}
