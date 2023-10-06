//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.gt.basketballapp.mapper;

import com.gt.basketballapp.model.Coordinates;
import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class CourtMapperImpl implements CourtMapper {
    public CourtMapperImpl() {
    }

    public Court toEntity(CourtDto courtDto) {
        if (courtDto == null) {
            return null;
        } else {
            Court.CourtBuilder court = Court.builder();
            court.name(courtDto.name());
            court.coordinates(courtDto.coordinates());
            court.renovationStatus(courtDto.renovationStatus());
            court.courtType(courtDto.courtType());
            return court.build();
        }
    }

    public CourtDto toDto(Court court) {
        if (court == null) {
            return null;
        } else {
            String name = null;
            Coordinates coordinates = null;
            RenovationStatus renovationStatus = null;
            CourtType courtType = null;
            name = court.getName();
            coordinates = court.getCoordinates();
            renovationStatus = court.getRenovationStatus();
            courtType = court.getCourtType();
            CourtDto courtDto = new CourtDto(name, coordinates, renovationStatus, courtType);
            return courtDto;
        }
    }

    public List<CourtDto> toDtoList(Iterable<Court> court) {
        if (court == null) {
            return null;
        } else {
            List<CourtDto> list = new ArrayList();
            Iterator var3 = court.iterator();

            while(var3.hasNext()) {
                Court court1 = (Court)var3.next();
                list.add(this.toDto(court1));
            }

            return list;
        }
    }

    public Court partialUpdate(CourtDto courtDto, Court court) {
        if (courtDto == null) {
            return court;
        } else {
            if (courtDto.name() != null) {
                court.setName(courtDto.name());
            }

            if (courtDto.coordinates() != null) {
                court.setCoordinates(courtDto.coordinates());
            }

            if (courtDto.renovationStatus() != null) {
                court.setRenovationStatus(courtDto.renovationStatus());
            }

            if (courtDto.courtType() != null) {
                court.setCourtType(courtDto.courtType());
            }

            return court;
        }
    }
}
