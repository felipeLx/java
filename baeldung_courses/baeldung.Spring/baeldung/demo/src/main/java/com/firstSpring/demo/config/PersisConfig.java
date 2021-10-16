package com.firstSpring.demo.config;

/*
** Code block to the activate WebConfig and App2Config
 */

/*import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
public class PersisConfig {

    @Bean
    public DataSource dataSource() {
        // not recommended because the limitation to start the dataBase from the line below
        //  return new EmbeddedDatabaseBuilder().setType(EmbeddedDatabaseType.H2).setName("learn-spring-db").build();

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver");
        dataSource.setUrl("jdbc:h2:mem:learn-spring-db;DB_CLOSE_DELAY=-1");
        dataSource.setUsername("username");
        dataSource.setPassword("password");

        return dataSource;
    }
}*/
