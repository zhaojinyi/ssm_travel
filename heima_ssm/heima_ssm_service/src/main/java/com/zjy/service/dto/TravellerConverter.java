package com.zjy.service.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zjy.domain.Traveller;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * @Auther: 无聊的人
 * @Date: 2019/4/28
 * @Description: com.zjy.service.dto
 */
@Mapper(componentModel = "spring")
public interface TravellerConverter {

    Traveller dtoToEntity(TravellerDto travellerDto);
    TravellerDto entityToDto(Traveller traveller);
    List<TravellerDto> listEntityToDto(List<Traveller> travellerList);
    List<Traveller> listDtoToEntity(List<TravellerDto> travellerDtoList);
    Page<TravellerDto> pageEntityToDto(Page<Traveller> page);

}