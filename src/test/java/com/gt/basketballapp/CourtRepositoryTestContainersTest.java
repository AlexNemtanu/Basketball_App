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
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void testDatabaseConnection() {
        String jdbcUrl = "jdbc:mysql://localhost:3306/basketballdb";
        String username = "admin";
        String password = "admin";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            assertTrue(connection.isValid(3), "Conexiunea la baza de date nu este validă.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
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