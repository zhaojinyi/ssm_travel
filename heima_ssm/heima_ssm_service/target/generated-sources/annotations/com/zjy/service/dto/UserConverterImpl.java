package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.UserInfo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-30T18:49:18+0800",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class UserConverterImpl implements UserConverter {

    @Override
    public UserInfo dtoToEntity(UserInfoDto userInfoDto) {
        if ( userInfoDto == null ) {
            return null;
        }

        UserInfo userInfo = new UserInfo();

        userInfo.setId( userInfoDto.getId() );
        userInfo.setUsername( userInfoDto.getUsername() );
        userInfo.setEmail( userInfoDto.getEmail() );
        userInfo.setPassword( userInfoDto.getPassword() );
        userInfo.setPhonenum( userInfoDto.getPhonenum() );
        userInfo.setStatus( userInfoDto.getStatus() );

        return userInfo;
    }

    @Override
    public UserInfoDto entityToDto(UserInfo userInfo) {
        if ( userInfo == null ) {
            return null;
        }

        UserInfoDto userInfoDto = new UserInfoDto();

        userInfoDto.setId( userInfo.getId() );
        userInfoDto.setUsername( userInfo.getUsername() );
        userInfoDto.setEmail( userInfo.getEmail() );
        userInfoDto.setPassword( userInfo.getPassword() );
        userInfoDto.setPhonenum( userInfo.getPhonenum() );
        userInfoDto.setStatus( userInfo.getStatus() );

        return userInfoDto;
    }

    @Override
    public List<UserInfoDto> listEntityToDto(List<UserInfo> userInfos) {
        if ( userInfos == null ) {
            return null;
        }

        List<UserInfoDto> list = new ArrayList<UserInfoDto>();
        for ( UserInfo userInfo : userInfos ) {
            list.add( entityToDto( userInfo ) );
        }

        return list;
    }

    @Override
    public List<UserInfo> listDtoToEntity(List<UserInfoDto> userInfoDtos) {
        if ( userInfoDtos == null ) {
            return null;
        }

        List<UserInfo> list = new ArrayList<UserInfo>();
        for ( UserInfoDto userInfoDto : userInfoDtos ) {
            list.add( dtoToEntity( userInfoDto ) );
        }

        return list;
    }

    @Override
    public Page<UserInfoDto> pageEntityToDto(Page<UserInfo> page) {
        if ( page == null ) {
            return null;
        }

        Page<UserInfoDto> page1 = new Page<UserInfoDto>();

        page1.setPages( page.getPages() );
        List<UserInfoDto> list = listEntityToDto( page.getRecords() );
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
