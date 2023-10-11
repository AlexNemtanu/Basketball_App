package com.gt.basketballapp;

import com.gt.basketballapp.mapper.CourtMapper;
import com.gt.basketballapp.model.Coordinates;
import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import com.gt.basketballapp.repository.CourtRepository;
import com.gt.basketballapp.service.impl.CourtServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class CourtServiceTest {
    @Mock
    private CourtRepository courtRepository;
    @Mock
    private CourtMapper courtMapper;
    @InjectMocks
    private CourtServiceImpl courtServiceImpl;
    private Court court1;
    private Court court2;

    private final CourtDto courtDto1 = new CourtDto(
            "test1",
            new Coordinates(2,2),
            RenovationStatus.RENOVATED,
            CourtType.INDOOR
    );

    private final CourtDto courtDto2 = new CourtDto(
            "test2",
            new Coordinates(-3,-3),
            RenovationStatus.NOT_RENOVATED,
            CourtType.OUTDOOR
    );


    @BeforeEach
    void setUp(){
        court1 = Court.builder()
                .id(2L)
                .name("test1")
                .courtType(CourtType.INDOOR)
                .renovationStatus(RenovationStatus.RENOVATED)
                .coordinates(new Coordinates(2, 2))
                .build();

        court2 = Court.builder()
                .id(3L)
                .name("test2")
                .courtType(CourtType.OUTDOOR)
                .renovationStatus(RenovationStatus.NOT_RENOVATED)
                .coordinates(new Coordinates(-3, -3))
                .build();
    }

    @DisplayName("JUnit test for save")
    @Test
    void save() {
        when(courtMapper.toEntity(courtDto1)).thenReturn(court1);

        courtServiceImpl.save(courtDto1);

        verify(courtRepository).save(court1);

        ArgumentCaptor<Court> courtCaptor = ArgumentCaptor.forClass(Court.class);
        verify(courtRepository).save(courtCaptor.capture());

        Court savedCourt = courtCaptor.getValue();
        assertEquals(court1, savedCourt);
    }

    @DisplayName("JUnit test for findById")
    @Test
    void findById() {
        when(courtMapper.toDto(court1)).thenReturn(courtDto1);
        when(courtRepository.findById(2L)).thenReturn(Optional.of(court1));

        CourtDto actual = courtServiceImpl.findById(court1.getId());

        assertNotNull(actual);
        assertEquals(courtDto1, actual);
    }

    @DisplayName("JUnit test for findAll")
    @Test
    void findAll() {
        when(courtMapper.toDtoList(List.of(court1, court2))).thenReturn(List.of(courtDto1, courtDto2));
        when(courtRepository.findAll()).thenReturn(List.of(court1, court2));

        List<CourtDto> actual = courtServiceImpl.findAll();

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto2, actual.get(1));
    }

    @DisplayName("JUnit test for findByName")
    @Test
    void findByName() {
        when(courtMapper.toDto(court1)).thenReturn(courtDto1);
        when(courtRepository.findByName("test1")).thenReturn(Optional.of(court1));

        CourtDto actual = courtServiceImpl.findByName(court1.getName());

        assertNotNull(actual);
        assertEquals(courtDto1, actual);
        assertEquals("test1", actual.name());
    }

    @DisplayName("JUnit test for existsByName")
    @Test
    void existsByName() {
        when(courtRepository.existsByName("test1")).thenReturn(true);

        boolean actual = courtServiceImpl.existsByName("test1");

        assertTrue(actual);
    }

    @DisplayName("JUnit test for findByRenovationStatus")
    @Test
    void findByRenovationStatus() {
        when(courtMapper.toDtoList(List.of(court1, court2))).thenReturn(List.of(courtDto1, courtDto2));
        when(courtRepository.findByRenovationStatus(RenovationStatus.RENOVATED)).thenReturn(List.of(court1, court2));

        List<CourtDto> actual = courtServiceImpl.findByRenovationStatus(RenovationStatus.RENOVATED);

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto2, actual.get(1));
    }

    @DisplayName("JUnit test for findByCourtType")
    @Test
    void findByCourtType() {
        when(courtMapper.toDtoList(List.of(court1, court2))).thenReturn(List.of(courtDto1, courtDto2));
        when(courtRepository.findByCourtType(CourtType.INDOOR)).thenReturn(List.of(court1, court2));

        List<CourtDto> actual = courtServiceImpl.findByCourtType(CourtType.INDOOR);

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto2, actual.get(1));
    }

    @DisplayName("JUnit test for countByRenovationStatus")
    @Test
    void countByRenovationStatus() {
        when(courtRepository.countByRenovationStatus(RenovationStatus.RENOVATED)).thenReturn(1L);

        Long actual = courtServiceImpl.countByRenovationStatus(RenovationStatus.RENOVATED);

        assertEquals(1, actual);
    }

    @DisplayName("JUnit test for countByCourtType")
    @Test
    void countByCourtType() {
        when(courtRepository.countByCourtType(CourtType.INDOOR)).thenReturn(1L);

        Long actual = courtServiceImpl.countByCourtType(CourtType.INDOOR);

        assertEquals(1, actual);
    }

    @DisplayName("JUnit test for findByRenovationStatusAndCourtType all provided arguments")
    @Test
    void findByRenovationStatusAndCourtType(){
        when(courtMapper.toDtoList(List.of(court1, court2))).thenReturn(List.of(courtDto1, courtDto2));
        when(courtRepository.findByRenovationStatusAndCourtType(RenovationStatus.RENOVATED, CourtType.INDOOR)).thenReturn(List.of(court1, court2));

        List<CourtDto> actual = courtServiceImpl.findByRenovationStatusAndCourtType(RenovationStatus.RENOVATED, CourtType.INDOOR);

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto2, actual.get(1));
    }

    @DisplayName("JUnit test for findByRenovationStatusAndCourtType only renovationStatus provided")
    @Test
    void findByRenovationStatusAndCourtTypeOnlyRenovationStatus(){
        when(courtMapper.toDtoList(List.of(court1))).thenReturn(List.of(courtDto1));
        when(courtRepository.findByRenovationStatus(RenovationStatus.RENOVATED)).thenReturn(List.of(court1));

        List<CourtDto> actual = courtServiceImpl.findByRenovationStatusAndCourtType(RenovationStatus.RENOVATED, null);

        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto1.renovationStatus(), actual.get(0).renovationStatus());
    }

    @DisplayName("JUnit test for findByRenovationStatusAndCourtType only courtType provided")
    @Test
    void findByRenovationStatusAndCourtTypeOnlyCourtType(){
        when(courtMapper.toDtoList(List.of(court1))).thenReturn(List.of(courtDto1));
        when(courtRepository.findByCourtType(CourtType.INDOOR)).thenReturn(List.of(court1));

        List<CourtDto> actual = courtServiceImpl.findByRenovationStatusAndCourtType(null, CourtType.INDOOR);

        assertNotNull(actual);
        assertEquals(1, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto1.courtType(), actual.get(0).courtType());
    }

    @DisplayName("JUnit test for findByRenovationStatusAndCourtType no arguments provided")
    @Test
    void findByRenovationStatusAndCourtTypeNoArguments(){
        when(courtMapper.toDtoList(List.of(court1, court2))).thenReturn(List.of(courtDto1, courtDto2));
        when(courtRepository.findAll()).thenReturn(List.of(court1, court2));

        List<CourtDto> actual = courtServiceImpl.findByRenovationStatusAndCourtType(null, null);

        assertNotNull(actual);
        assertEquals(2, actual.size());
        assertEquals(courtDto1, actual.get(0));
        assertEquals(courtDto2, actual.get(1));
    }

}