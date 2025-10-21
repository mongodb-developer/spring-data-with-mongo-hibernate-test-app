package org.example.springwithhibernatetestapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.example.springwithhibernatetestapp")
@EntityScan(basePackages = "org.example.springwithhibernatetestapp")
public class SpringWithHibernateMongoTestAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringWithHibernateMongoTestAppApplication.class, args);
    }

}
