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
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("repo-test")
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@DataJpaTest
class CourtRepositoryTest{
    @Autowired
    private CourtRepository courtRepository;
    @Test
    void findAllIndoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(INDOOR);
        assertTrue(courts.isEmpty());
    }
    @Test
    void findAllOutdoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(OUTDOOR);
        assertTrue(courts.isEmpty());
    }
    @Test
    void findRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RENOVATED);
        assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(RENOVATED, court.getRenovationStatus());
    }
    @Test
    void findNotRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.NOT_RENOVATED);
        assertFalse(courts.isEmpty());
        for(Court court:courts)
            Assertions.assertEquals(NOT_RENOVATED, court.getRenovationStatus());
    }
    @Test
    void findUnderRenovationCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.UNDER_RENOVATION);
        assertTrue(courts.isEmpty());
    }
}