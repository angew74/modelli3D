package com.roma.elettorale.modelli3D;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@Qualifier("faxpecBean")
@EnableJpaRepositories(entityManagerFactoryRef = "FaxPecEntityManagerFactory",
        transactionManagerRef = "FaxPecTransactionManager",
        basePackages = {"com.roma.elettorale.modelli3D.faxpec.repository"})
public class FaxPecDbConfig {


    @Bean(name = "FaxPecDataSource")
    @ConfigurationProperties(prefix = "faxpec.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "FaxPecEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("FaxPecDataSource") DataSource dataSource) {
        return builder.dataSource(dataSource).packages("com.roma.elettorale.modelli3D.faxpec.entity").persistenceUnit("faxpec")
                .build();
    }


    @Bean(name = "FaxPecTransactionManager")
    public PlatformTransactionManager transactionManager(
            @Qualifier("FaxPecEntityManagerFactory") EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }
}
