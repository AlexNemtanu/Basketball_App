package com.gt.basketballapp;

import com.gt.basketballapp.mapper.CourtMapper;
import com.gt.basketballapp.mapper.CourtMapperImpl;
import com.gt.basketballapp.model.Coordinates;
import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.model.dto.CourtDto;
import com.gt.basketballapp.repository.CourtRepository;
import com.gt.basketballapp.service.impl.CourtServiceImpl;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.assertj.core.api.Assertions.anyOf;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ServiceTest {
    @Mock
    private CourtRepository courtRepository;

    private final CourtMapper courtMapper = new CourtMapperImpl();
    @InjectMocks
    private CourtServiceImpl courtServiceImpl;

    private Court courtToSave;


    @BeforeEach
    void setUp(){
        MockitoAnnotations.initMocks(this);

        this.courtToSave = Court
                .builder()
                .id(1L)
                .name("test")
                .courtType(CourtType.OUTDOOR)
                .renovationStatus(RenovationStatus.RENOVATED)
                .coordinates(new Coordinates(1, 1))
                .build();

        this.courtServiceImpl = new CourtServiceImpl(courtMapper, courtRepository);
    }

    @DisplayName("JUnit test for save IF PROVIDE AS PARAMETER AN OBJECT OF TYPE COURT..." )
    @Test
    void save() {
        //final var actual = courtServiceImpl.save(courtMapper.toDto(courtToSave));
        final var actual = courtServiceImpl.save(courtToSave);

        assertThat(actual).usingRecursiveComparison().isEqualTo(courtToSave);
    }

    @DisplayName("Junit test for findById")
    @Test
    void findById() {
        CourtDto courtDto = courtMapper.toDto(courtToSave);
        when(courtServiceImpl.findById(anyLong())).thenReturn(courtDto);
        courtServiceImpl.save(courtDto);

        //final var actual = courtServiceImpl.findById(1L);
        final var actual = courtServiceImpl.findById(1L);


        assertThat(actual).usingRecursiveComparison().isEqualTo(courtDto);
        //assertThat(actual.name()).isEqualTo(courtMapper.toDto(courtToSave).name());

    }

    @DisplayName("JUnit test for findAll")
    @Test
    void findAll() {

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
}