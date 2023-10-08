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
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ServiceTest {
    @Mock
    private CourtRepository courtRepository = mock(CourtRepository.class);
    @Spy
    private CourtMapper courtMapper = Mappers.getMapper(CourtMapper.class);
    @InjectMocks
    private CourtServiceImpl courtServiceImpl = mock(CourtServiceImpl.class);
    private Court courtToSave;

    @BeforeEach
    void setUp(){
        this.courtToSave = Court
                .builder()
                .id(1L)
                .name("test")
                .courtType(CourtType.OUTDOOR)
                .renovationStatus(RenovationStatus.RENOVATED)
                .coordinates(new Coordinates(1, 1))
                .build();

        MockitoAnnotations.openMocks(this);
    }

    @DisplayName("JUnit test for save")
    @Test
    void save() {
        courtServiceImpl.save(courtMapper.toDto(courtToSave));

        verify(courtServiceImpl, times(1)).save(courtMapper.toDto(courtToSave));
    }

    @DisplayName("Junit test for findById")
    @Test
    void findById() {
       CourtDto courtDto = courtMapper.toDto(courtToSave);
        given(courtServiceImpl.findById(1L)).willReturn(courtDto);

        CourtDto returnCourt = courtServiceImpl.findById(1L);

        assertNotNull(returnCourt);
        assertEquals(courtMapper.toDto(courtToSave), returnCourt);
    }

    @DisplayName("JUnit test for findAll")
    @Test
    void findAll() {
        Court court2 = Court.builder()
                .id(2L)
                .name("test2")
                .courtType(CourtType.INDOOR)
                .renovationStatus(RenovationStatus.UNDER_RENOVATION)
                .coordinates(new Coordinates(2, 2))
                .build();
        List<Court> courts = List.of(courtToSave, court2);

        List<CourtDto> expectedList = courtMapper.toDtoList(courts);
        when(courtServiceImpl.findAll()).thenReturn(expectedList);

        List<CourtDto> actualList = courtServiceImpl.findAll();

        assertNotNull(actualList);
        assertEquals(expectedList,actualList);
    }

    @DisplayName("JUnit test for findByName")
    @Test
    void findByName() {
    }

    @DisplayName("JUnit test for existsByName")
    @Test
    void existsByName() {
    }

    @DisplayName("JUnit test for findByRenovationStatus")
    @Test
    void findByRenovationStatus() {
    }

    @DisplayName("JUnit test for findByCourtType")
    @Test
    void findByCourtType() {
    }

    @DisplayName("JUnit test for countByRenovationStatus")
    @Test
    void countByRenovationStatus() {
    }

    @DisplayName("JUnit test for countByCourtType")
    @Test
    void countByCourtType() {
    }


    @Test
    void infoMocking(){
        System.out.println("Is am mock object? " + mockingDetails(courtServiceImpl).isMock());
        System.out.println("Is am mock object? " + mockingDetails(courtRepository).isMock());
        System.out.println("Is am mock object? " + mockingDetails(courtMapper).isMock());
    }
}