package com.gt.basketballapp.service;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;

import java.util.List;

public interface CourtService {

    Court findByName(String name);

    boolean existsByName(String name);

    List<Court> findByRenovationStatus(RenovationStatus renovationStatus);

    List<Court> findByCourtType(CourtType courtType);

    long countByRenovationStatus(RenovationStatus renovationStatus);

    long countByCourtType(CourtType courtType);

}
