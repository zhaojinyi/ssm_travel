package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.SysLog;
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
public class SysLogConverterImpl implements SysLogConverter {

    @Override
    public SysLog dtoToEntity(SysLogDto sysLogDto) {
        if ( sysLogDto == null ) {
            return null;
        }

        SysLog sysLog = new SysLog();

        sysLog.setId( sysLogDto.getId() );
        sysLog.setVisittime( sysLogDto.getVisittime() );
        sysLog.setUsername( sysLogDto.getUsername() );
        sysLog.setIp( sysLogDto.getIp() );
        sysLog.setUrl( sysLogDto.getUrl() );
        sysLog.setExecutiontime( sysLogDto.getExecutiontime() );
        sysLog.setMethod( sysLogDto.getMethod() );

        return sysLog;
    }

    @Override
    public SysLogDto entityToDto(SysLog sysLog) {
        if ( sysLog == null ) {
            return null;
        }

        SysLogDto sysLogDto = new SysLogDto();

        sysLogDto.setId( sysLog.getId() );
        sysLogDto.setVisittime( sysLog.getVisittime() );
        sysLogDto.setUsername( sysLog.getUsername() );
        sysLogDto.setIp( sysLog.getIp() );
        sysLogDto.setUrl( sysLog.getUrl() );
        sysLogDto.setExecutiontime( sysLog.getExecutiontime() );
        sysLogDto.setMethod( sysLog.getMethod() );

        return sysLogDto;
    }

    @Override
    public List<SysLogDto> listEntityToDto(List<SysLog> sysLogList) {
        if ( sysLogList == null ) {
            return null;
        }

        List<SysLogDto> list = new ArrayList<SysLogDto>();
        for ( SysLog sysLog : sysLogList ) {
            list.add( entityToDto( sysLog ) );
        }

        return list;
    }

    @Override
    public List<SysLog> listDtoToEntity(List<SysLogDto> sysLogDtoList) {
        if ( sysLogDtoList == null ) {
            return null;
        }

        List<SysLog> list = new ArrayList<SysLog>();
        for ( SysLogDto sysLogDto : sysLogDtoList ) {
            list.add( dtoToEntity( sysLogDto ) );
        }

        return list;
    }

    @Override
    public Page<SysLogDto> pageEntityToDto(Page<SysLog> page) {
        if ( page == null ) {
            return null;
        }

        Page<SysLogDto> page1 = new Page<SysLogDto>();

        page1.setPages( page.getPages() );
        List<SysLogDto> list = listEntityToDto( page.getRecords() );
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
