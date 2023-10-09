package com.gt.basketballapp;

import com.gt.basketballapp.mapper.CourtMapper;
import com.gt.basketballapp.model.Coordinates;
import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import com.gt.basketballapp.repository.CourtRepository;
import com.gt.basketballapp.service.impl.CourtServiceImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ServiceTest {
    @Mock
    private CourtRepository courtRepository = mock(CourtRepository.class);
    @Spy
    private CourtMapper courtMapper = Mappers.getMapper(CourtMapper.class);
    @InjectMocks
    private CourtServiceImpl courtServiceImpl = mock(CourtServiceImpl.class);
    private Court court1;
    private Court court2;


    @BeforeEach
    void setUp(){
        this.court1 = Court.builder()
                .id(2L)
                .name("test1")
                .courtType(CourtType.INDOOR)
                .renovationStatus(RenovationStatus.RENOVATED)
                .coordinates(new Coordinates(2, 2))
                .build();
        this.court2 = Court.builder()
                .id(3L)
                .name("test2")
                .courtType(CourtType.INDOOR)
                .renovationStatus(RenovationStatus.RENOVATED)
                .coordinates(new Coordinates(2, 2))
                .build();

        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("JUnit test for save")
    @Test
    void save() {
        CourtDto courtDtoToSave = courtMapper.toDto(court1);
        willDoNothing().given(courtServiceImpl).save(courtDtoToSave);

        courtServiceImpl.save(courtDtoToSave);

        verify(courtServiceImpl, times(1)).save(courtDtoToSave);
    }

    @DisplayName("Junit test for findById")
    @Test
    void findById() {
        CourtDto courtDto = courtMapper.toDto(court1);
        given(courtServiceImpl.findById(court1.getId())).willReturn(courtDto);

        CourtDto returnCourt = courtServiceImpl.findById(court1.getId());

        assertNotNull(returnCourt);
        assertEquals(courtDto, returnCourt);
    }

    @DisplayName("JUnit test for findAll")
    @Test
    void findAll() {
        List<Court> courts = List.of(court1, court2);
        List<CourtDto> expectedList = courtMapper.toDtoList(courts);
        given(courtServiceImpl.findAll()).willReturn(expectedList);

        List<CourtDto> returnList = courtServiceImpl.findAll();

        assertNotNull(returnList);
        assertEquals(expectedList,returnList);
        assertEquals(expectedList.size(), returnList.size());
    }

    @DisplayName("JUnit test for findByName")
    @Test
    void findByName() {
        CourtDto expectedCourt = courtMapper.toDto(court1);
        given(courtServiceImpl.findByName(court1.getName())).willReturn(expectedCourt);

        CourtDto returnCourt = courtServiceImpl.findByName(court1.getName());

        assertNotNull(returnCourt);
        assertEquals(expectedCourt.name(), returnCourt.name());
        assertEquals("test1", returnCourt.name());
    }

    @DisplayName("JUnit test for existsByName")
    @Test
    void existsByName() {
        CourtDto courtDtoToSave = courtMapper.toDto(court1);
        when(courtServiceImpl.existsByName(courtDtoToSave.name())).thenReturn(true);

        assertTrue(courtServiceImpl.existsByName(court1.getName()));
    }

    @DisplayName("JUnit test for findByRenovationStatus")
    @Test
    void findByRenovationStatus() {
        List<Court> courts = List.of(court1, court2);
        List<CourtDto> expectedList = courtMapper.toDtoList(courts);
        when(courtServiceImpl.findByRenovationStatus(any(RenovationStatus.class))).thenReturn(expectedList);

        List<CourtDto> returnList = courtServiceImpl.findByRenovationStatus(RenovationStatus.RENOVATED);

        assertNotNull(returnList);
        assertEquals(expectedList,returnList);
        assertEquals(expectedList.size(), returnList.size());
        assertEquals(2, returnList.size());
        assertEquals(RenovationStatus.RENOVATED, returnList.get(0).renovationStatus());

    }

    @DisplayName("JUnit test for findByCourtType")
    @Test
    void findByCourtType() {
        List<Court> courts = List.of(court1, court2);
        List<CourtDto> expectedList = courtMapper.toDtoList(courts);
        when(courtServiceImpl.findByCourtType(CourtType.INDOOR)).thenReturn(expectedList);

        List<CourtDto> returnList = courtServiceImpl.findByCourtType(CourtType.INDOOR);

        assertNotNull(returnList);
        assertEquals(expectedList,returnList);
        assertEquals(expectedList.size(), returnList.size());
        assertEquals(2, returnList.size());
        assertEquals(CourtType.INDOOR, returnList.get(0).courtType());
    }

    @DisplayName("JUnit test for countByRenovationStatus")
    @Test
    void countByRenovationStatus() {
        when(courtServiceImpl.countByRenovationStatus(RenovationStatus.RENOVATED)).thenReturn(2L);

        Long actual = courtServiceImpl.countByRenovationStatus(RenovationStatus.RENOVATED);

        assertEquals(2, actual);
    }

    @DisplayName("JUnit test for countByCourtType")
    @Test
    void countByCourtType() {
        when(courtServiceImpl.countByCourtType(CourtType.INDOOR)).thenReturn(2L);

        Long actual = courtServiceImpl.countByCourtType(CourtType.INDOOR);

        assertEquals(2, actual);
    }

}