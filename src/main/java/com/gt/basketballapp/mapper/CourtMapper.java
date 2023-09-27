package com.gt.basketballapp.mapper;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.dto.CourtDto;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourtMapper {
    Court toEntity(CourtDto courtDto);

    CourtDto toDto(Court court);

    List<CourtDto> toDtoList(Iterable<Court> court);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Court partialUpdate(CourtDto courtDto, @MappingTarget Court court);
}