package com.gt.basketballapp.service;

import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;

import java.util.List;
import java.util.Optional;

public interface CourtService {

    CourtDto findByName(String name);

    boolean existsByName(String name);

    List<CourtDto> findByRenovationStatus(RenovationStatus renovationStatus);

    List<CourtDto> findByCourtType(CourtType courtType);

    long countByRenovationStatus(RenovationStatus renovationStatus);

    long countByCourtType(CourtType courtType);

}
