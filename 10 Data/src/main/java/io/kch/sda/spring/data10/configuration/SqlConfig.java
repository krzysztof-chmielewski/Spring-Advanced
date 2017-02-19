package io.kch.sda.spring.data10.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:sql/mysql-config.properties")
public class SqlConfig {
    @Value("${database.host}")
    private String host;

    @Value("${database.database}")
    private String database;

    @Value("${database.user}")
    private String user;

    @Value("${database.password}")
    private String password;

    @Bean
    @Profile("test")
    public DataSource testDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        builder.setType(EmbeddedDatabaseType.H2).addScripts("sql/structure.sql", "sql/data.sql");
        return builder.build();
    }

    @Bean
    @Profile("development")
    public DataSource mysql() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://" + host + ":3306/" + database + "?serverTimezone=UTC");
        dataSource.setUsername(user);
        dataSource.setPassword(password);

        return dataSource;
    }
}
