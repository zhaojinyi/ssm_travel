package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Permission;
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
public class PermissionConverterImpl implements PermissionConverter {

    @Override
    public Permission dtoToEntity(PermissionDto permissionDto) {
        if ( permissionDto == null ) {
            return null;
        }

        Permission permission = new Permission();

        permission.setId( permissionDto.getId() );
        permission.setPermissionname( permissionDto.getPermissionname() );
        permission.setUrl( permissionDto.getUrl() );

        return permission;
    }

    @Override
    public PermissionDto entityToDto(Permission permission) {
        if ( permission == null ) {
            return null;
        }

        PermissionDto permissionDto = new PermissionDto();

        permissionDto.setId( permission.getId() );
        permissionDto.setPermissionname( permission.getPermissionname() );
        permissionDto.setUrl( permission.getUrl() );

        return permissionDto;
    }

    @Override
    public List<PermissionDto> listEntityToDto(List<Permission> permissionList) {
        if ( permissionList == null ) {
            return null;
        }

        List<PermissionDto> list = new ArrayList<PermissionDto>();
        for ( Permission permission : permissionList ) {
            list.add( entityToDto( permission ) );
        }

        return list;
    }

    @Override
    public List<Permission> listDtoToEntity(List<PermissionDto> permissionDtoList) {
        if ( permissionDtoList == null ) {
            return null;
        }

        List<Permission> list = new ArrayList<Permission>();
        for ( PermissionDto permissionDto : permissionDtoList ) {
            list.add( dtoToEntity( permissionDto ) );
        }

        return list;
    }

    @Override
    public Page<PermissionDto> pageEntityToDto(Page<Permission> page) {
        if ( page == null ) {
            return null;
        }

        Page<PermissionDto> page1 = new Page<PermissionDto>();

        page1.setPages( page.getPages() );
        List<PermissionDto> list = listEntityToDto( page.getRecords() );
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
