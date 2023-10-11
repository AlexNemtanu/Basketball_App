package com.gt.basketballapp;

import org.jetbrains.annotations.NotNull;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.TestPropertySourceUtils;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ContextConfiguration(initializers = AbstractMySQLTestContainerIT.Initializer.class)
@Testcontainers
public abstract class AbstractMySQLTestContainerIT {
    @Container
    static MySQLContainer<?> database = new MySQLContainer<>(DockerImageName.parse("mysql:5.7.34"));

    static class Initializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        @Override
        public void initialize(@NotNull ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertySourceUtils.addInlinedPropertiesToEnvironment(
                    configurableApplicationContext,
                        "spring.datasource.url=" + database.getJdbcUrl(),
                        "spring.datasource.driverClassName"+database.getDriverClassName(),
                        "spring.datasource.username"+database.getUsername(),
                        "spring.datasource.password"+database.getPassword(),
                        "spring.flyway.enabled"+"true"
            );
        }
    }
}