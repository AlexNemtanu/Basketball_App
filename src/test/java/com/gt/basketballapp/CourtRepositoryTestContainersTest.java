package com.gt.basketballapp;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.repository.CourtRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static com.gt.basketballapp.model.CourtType.INDOOR;
import static com.gt.basketballapp.model.CourtType.OUTDOOR;
import static com.gt.basketballapp.model.RenovationStatus.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Testcontainers
@DataJpaTest
@Sql(scripts={"create-data.sql"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CourtRepositoryTestContainersTest {
    /*
    @BeforeAll
    static void init() {
        new MySQLContainer("mysql")
                .withDatabaseName("basketballdb")
                .withUsername("admin")
                .withPassword("admin")
                .start();
    }*/

    @Autowired
    private CourtRepository courtRepository;
    @Test
    public void findAllIndoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(INDOOR);
        for(Court court:courts){
            System.out.println(court.getCourtType());
            Assertions.assertEquals(INDOOR,court.getCourtType());
        }
    }
    @Test
    public void findAllOutdoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(OUTDOOR);
        for(Court court:courts) {
            System.out.println(court.getCourtType());
            Assertions.assertEquals(OUTDOOR, court.getCourtType());
        }
    }
    @Test
    public void findRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RENOVATED);
        for(Court court:courts) {
            System.out.println(court.getRenovationStatus());
            Assertions.assertEquals(RENOVATED, court.getRenovationStatus());
        }
    }
    @Test
    public void findUnrenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.NOT_RENOVATED);
        for(Court court:courts) {
            System.out.println(court.getRenovationStatus());
            Assertions.assertEquals(NOT_RENOVATED, court.getRenovationStatus());
        }
    }
    @Test
    public void findInProgressCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.UNDER_RENOVATION);
        for(Court court:courts) {
            System.out.println(court.getRenovationStatus());
            Assertions.assertEquals(UNDER_RENOVATION, court.getRenovationStatus());
        }
    }
}