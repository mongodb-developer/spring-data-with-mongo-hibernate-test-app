package org.example.springwithhibernatetestapp;

import jakarta.persistence.EntityManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class JpaMongoConfig {

    @Bean
    LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        var adapter = new HibernateJpaVendorAdapter();
        adapter.setShowSql(true);

        var emf = new LocalContainerEntityManagerFactoryBean();

        Map<String, Object> props = new HashMap<>();
        props.put("hibernate.connection.provider_class", "com.mongodb.hibernate.jdbc.MongoConnectionProvider");
        props.put("hibernate.dialect", "com.mongodb.hibernate.dialect.MongoDialect");
        props.put("jakarta.persistence.jdbc.url", "mongodb://127.0.0.1:27017/mongo-hibernate-test");

        emf.setJpaVendorAdapter(adapter);
        emf.setPackagesToScan("org.example.springwithhibernatetestapp");
        emf.setJpaPropertyMap(props);
        return emf;
    }

    @Bean
    JpaTransactionManager transactionManager(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}