package com.gt.basketballapp;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.RenovationStatus;
import com.gt.basketballapp.repository.CourtRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static com.gt.basketballapp.model.CourtType.INDOOR;
import static com.gt.basketballapp.model.CourtType.OUTDOOR;
import static com.gt.basketballapp.model.RenovationStatus.*;

@Testcontainers
@DataJpaTest
@Sql(scripts={"create-data.sql"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource("classpath:application-test.properties")
public class CourtRepositoryTestContainersTest {
    /*
    static MySQLContainer<?> mySQLContainer=new MySQLContainer<>("mysql:latest");
    @DynamicPropertySource
    static void configureProperties(DynamicPropertyRegistry registry){
        registry.add("spring.datasource.url",mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.url.username",mySQLContainer::getUsername);
        registry.add("spring.datasource.url.password",mySQLContainer::getPassword);
    }
    @BeforeAll
    static void beforeAll(){
        mySQLContainer.start();
    }
    @AfterAll
    static void afterAll() {
        mySQLContainer.stop();
    }

     */
    @Autowired
    private CourtRepository courtRepository;
    @Test
    public void findAllIndoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(INDOOR);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts){
            Assertions.assertEquals(INDOOR,court.getCourtType());
        }
    }
    @Test
    public void findAllOutdoorCourts() {
        List<Court> courts = courtRepository.findByCourtType(OUTDOOR);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts) {
            Assertions.assertEquals(OUTDOOR, court.getCourtType());
        }
    }
    @Test
    public void findRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RENOVATED);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts) {
            Assertions.assertEquals(RENOVATED, court.getRenovationStatus());
        }
    }
    @Test
    public void findNotRenovatedCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.NOT_RENOVATED);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts) {
            Assertions.assertEquals(NOT_RENOVATED, court.getRenovationStatus());
        }
    }
    @Test
    public void findInProgressCourts() {
        List<Court> courts = courtRepository.findByRenovationStatus(RenovationStatus.UNDER_RENOVATION);
        Assertions.assertFalse(courts.isEmpty());
        for(Court court:courts) {
            Assertions.assertEquals(UNDER_RENOVATION, court.getRenovationStatus());
        }
    }
}