package com.gt.basketballapp.service.impl;

import com.gt.basketballapp.exception.CourtNotFoundException;
import com.gt.basketballapp.mapper.CourtMapper;
import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import com.gt.basketballapp.repository.CourtRepository;
import com.gt.basketballapp.service.CourtService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
public class CourtServiceImpl implements CourtService {

    private final CourtMapper courtMapper;
    private final CourtRepository courtRepository;

    @Override
    public void save(CourtDto courtDto){
        Court court = courtMapper.toEntity(courtDto);
        courtRepository.save(court);
    }

    @Override
    public CourtDto findById(Long id){
        Court court = courtRepository.findById(id).orElseThrow(() -> new CourtNotFoundException("id: " + id));
        return courtMapper.toDto(court);
    }

    @Override
    public List<CourtDto> findAll(){
        List<Court> courts = courtRepository.findAll();
        return courtMapper.toDtoList(courts);
    }

    @Override
    public CourtDto findByName(String name){
        Court court = courtRepository.findByName(name).orElseThrow(() -> new CourtNotFoundException("name: " + name));
        return courtMapper.toDto(court);
    }

    @Override
    public boolean existsByName(String name){
        return courtRepository.existsByName(name);
    }

    @Override
    public List<CourtDto> findByRenovationStatus(RenovationStatus renovationStatus) {
        List<Court> courts = courtRepository.findByRenovationStatus(renovationStatus);
        return courtMapper.toDtoList(courts);
    }

    @Override
    public List<CourtDto> findByCourtType(CourtType courtType) {
        List<Court> courts = courtRepository.findByCourtType(courtType);
        return courtMapper.toDtoList(courts);
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
