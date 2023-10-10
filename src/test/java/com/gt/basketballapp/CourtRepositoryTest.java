package com.gt.basketballapp;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.repository.CourtRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.context.annotation.FilterType;
import org.springframework.data.repository.support.Repositories;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static com.gt.basketballapp.model.CourtType.*;
import static com.gt.basketballapp.model.RenovationStatus.*;

@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest(includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Repositories.class))
@Sql("/createData.sql")
@ActiveProfiles("repo-test")
public class CourtRepositoryTest {
    @Autowired
    private CourtRepository courtRepository;
    @Test
    void findAllIndoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(INDOOR);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(INDOOR,court.getCourtType());
    }
    @Test
    void findAllOutdoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(OUTDOOR);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(OUTDOOR, court.getCourtType());
    }
    @Test
    void findRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RENOVATED);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(RENOVATED, court.getRenovationStatus());
    }
    @Test
    void findNotRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.NOT_RENOVATED);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(NOT_RENOVATED, court.getRenovationStatus());
    }
    @Test
    void findInProgressCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.UNDER_RENOVATION);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(UNDER_RENOVATION, court.getRenovationStatus());
    }
}