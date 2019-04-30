package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Traveller;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-30T21:01:38+0800",
    comments = "version: 1.2.0.Beta2, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class TravellerConverterImpl implements TravellerConverter {

    @Override
    public Traveller dtoToEntity(TravellerDto travellerDto) {
        if ( travellerDto == null ) {
            return null;
        }

        Traveller traveller = new Traveller();

        traveller.setId( travellerDto.getId() );
        traveller.setName( travellerDto.getName() );
        traveller.setSex( travellerDto.getSex() );
        traveller.setPhonenum( travellerDto.getPhonenum() );
        traveller.setCredentialstype( travellerDto.getCredentialstype() );
        traveller.setCredentialsnum( travellerDto.getCredentialsnum() );
        traveller.setTravellertype( travellerDto.getTravellertype() );

        return traveller;
    }

    @Override
    public TravellerDto entityToDto(Traveller traveller) {
        if ( traveller == null ) {
            return null;
        }

        TravellerDto travellerDto = new TravellerDto();

        travellerDto.setId( traveller.getId() );
        travellerDto.setName( traveller.getName() );
        travellerDto.setSex( traveller.getSex() );
        travellerDto.setPhonenum( traveller.getPhonenum() );
        travellerDto.setCredentialstype( traveller.getCredentialstype() );
        travellerDto.setCredentialsnum( traveller.getCredentialsnum() );
        travellerDto.setTravellertype( traveller.getTravellertype() );

        return travellerDto;
    }

    @Override
    public List<TravellerDto> listEntityToDto(List<Traveller> travellerList) {
        if ( travellerList == null ) {
            return null;
        }

        List<TravellerDto> list = new ArrayList<TravellerDto>();
        for ( Traveller traveller : travellerList ) {
            list.add( entityToDto( traveller ) );
        }

        return list;
    }

    @Override
    public List<Traveller> listDtoToEntity(List<TravellerDto> travellerDtoList) {
        if ( travellerDtoList == null ) {
            return null;
        }

        List<Traveller> list = new ArrayList<Traveller>();
        for ( TravellerDto travellerDto : travellerDtoList ) {
            list.add( dtoToEntity( travellerDto ) );
        }

        return list;
    }

    @Override
    public Page<TravellerDto> pageEntityToDto(Page<Traveller> page) {
        if ( page == null ) {
            return null;
        }

        Page<TravellerDto> page1 = new Page<TravellerDto>();

        page1.setPages( page.getPages() );
        List<TravellerDto> list = listEntityToDto( page.getRecords() );
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
