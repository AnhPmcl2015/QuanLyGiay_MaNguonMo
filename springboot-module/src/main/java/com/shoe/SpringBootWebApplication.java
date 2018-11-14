package com.shoe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jms.JndiConnectionFactoryAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {JndiConnectionFactoryAutoConfiguration.class, DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class, JpaRepositoriesAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class})
@EnableJpaRepositories("com.shoe.jpa")
public class SpringBootWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }
}