package com.gt.basketballapp;

import com.gt.basketballapp.model.Court;
import com.gt.basketballapp.model.CourtType;
import com.gt.basketballapp.repository.CourtRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

@Testcontainers
@DataJpaTest
@Sql(scripts={"create-data.sql"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@SpringBootTest
public class CourtRepositoryTestContainersTest {
    @BeforeAll
    static void init() {
        new MySQLContainer("mysql")
                .withDatabaseName("basketballdb")
                .withUsername("admin")
                .withPassword("admin")
                .start();
    }

    @Autowired
    private CourtRepository courtRepository;

    @Test
    public void findCourtByNameTest() {
        Court court = courtRepository.findByName("testName1");
        Assertions.assertNotNull(court);
        Assertions.assertEquals("testName1", court.getName());
    }

    @Test
    public void findCourtsByCourtTypeTest() {
        List<Court> courts = courtRepository.findByCourtType(CourtType.INDOOR);
        Assertions.assertFalse(courts.isEmpty());
    }
}