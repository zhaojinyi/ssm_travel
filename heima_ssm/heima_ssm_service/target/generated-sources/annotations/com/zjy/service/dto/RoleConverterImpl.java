package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Role;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-30T23:38:28+0800",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class RoleConverterImpl implements RoleConverter {

    @Override
    public Role dtoToEntity(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role role = new Role();

        role.setId( roleDto.getId() );
        role.setRolename( roleDto.getRolename() );
        role.setRoledesc( roleDto.getRoledesc() );

        return role;
    }

    @Override
    public RoleDto entityToDto(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDto roleDto = new RoleDto();

        roleDto.setId( role.getId() );
        roleDto.setRolename( role.getRolename() );
        roleDto.setRoledesc( role.getRoledesc() );

        return roleDto;
    }

    @Override
    public List<RoleDto> listEntityToDto(List<Role> roles) {
        if ( roles == null ) {
            return null;
        }

        List<RoleDto> list = new ArrayList<RoleDto>();
        for ( Role role : roles ) {
            list.add( entityToDto( role ) );
        }

        return list;
    }

    @Override
    public List<Role> listDtoToEntity(List<RoleDto> roleDtos) {
        if ( roleDtos == null ) {
            return null;
        }

        List<Role> list = new ArrayList<Role>();
        for ( RoleDto roleDto : roleDtos ) {
            list.add( dtoToEntity( roleDto ) );
        }

        return list;
    }

    @Override
    public Page<RoleDto> pageEntityToDto(Page<Role> page) {
        if ( page == null ) {
            return null;
        }

        Page<RoleDto> page1 = new Page<RoleDto>();

        page1.setPages( page.getPages() );
        List<RoleDto> list = listEntityToDto( page.getRecords() );
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
