package com.gt.basketballapp.mapper;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface CourtMapper {
    Court toEntity(CourtDto courtDto);

    CourtDto toDto(Court court);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Court partialUpdate(CourtDto courtDto, @MappingTarget Court court);
}