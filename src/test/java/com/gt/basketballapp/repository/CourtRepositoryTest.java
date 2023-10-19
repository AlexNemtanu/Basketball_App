package com.gt.basketballapp.repository;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.RenovationStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static com.gt.basketballapp.model.CourtType.INDOOR;
import static com.gt.basketballapp.model.CourtType.OUTDOOR;
import static com.gt.basketballapp.model.RenovationStatus.NOT_RENOVATED;
import static com.gt.basketballapp.model.RenovationStatus.RENOVATED;

@ActiveProfiles("repo-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class CourtRepositoryTest{
    @Autowired
    private CourtRepository courtRepository;
    @Test
    void findAllIndoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(INDOOR);
        Assertions.assertTrue(courts.isEmpty());
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
    void findUnderRenovationCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.UNDER_RENOVATION);
        Assertions.assertTrue(courts.isEmpty());
    }
}