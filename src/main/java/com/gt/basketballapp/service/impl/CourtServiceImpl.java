package com.gt.basketballapp.service.impl;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.repository.CourtRepository;
import com.gt.basketballapp.service.CourtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourtServiceImpl implements CourtService {

    private final CourtRepository courtRepository;

    public CourtServiceImpl(CourtRepository courtRepository) {
        this.courtRepository = courtRepository;
    }

    @Override
    public Court findByName(String name) {
        return courtRepository.findByName(name);
    }

    @Override
    public boolean existsByName(String name) {
        return courtRepository.existsByName(name);
    }

    @Override
    public List<Court> findByRenovationStatus(RenovationStatus renovationStatus) {
        return courtRepository.findByRenovationStatus(renovationStatus);
    }

    @Override
    public List<Court> findByCourtType(CourtType courtType) {
        return courtRepository.findByCourtType(courtType);
    }

    @Override
    public long countByRenovationStatus(RenovationStatus renovationStatus) {
        return courtRepository.countByRenovationStatus(renovationStatus);
    }

    @Override
    public long countByCourtType(CourtType courtType) {
        return courtRepository.countByCourtType(courtType);
    }
}
