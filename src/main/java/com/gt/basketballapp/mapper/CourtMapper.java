package com.gt.basketballapp.mapper;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.dto.CourtDto;
import org.mapstruct.*;
import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CourtMapper {
    Court toEntity(CourtDto courtDto);

    @Mapping(target = "courtType", expression = "java(getEnumLabel(court))")
    CourtDto toDto(Court court);

    List<CourtDto> toDtoList(Iterable<Court> court);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Court partialUpdate(CourtDto courtDto, @MappingTarget Court court);

    default String getEnumLabel(Court court) {
        return court.getCourtType().label;
    }
}