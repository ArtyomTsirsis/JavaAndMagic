package com.game.config;

import liquibase.integration.spring.SpringLiquibase;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.game")
@PropertySource("classpath:application.properties")
@EnableTransactionManagement
public class DBConfig {

    @Value("${database.url}")
    private String databaseUrl;
    @Value("${database.user}")
    private String databaseUser;
    @Value("${database.password}")
    private String databasePassword;
    @Value("${database.driver}")
    private String databaseDriver;
    @Value("${hibernate.hbm2ddl.auto}")
    private String ddl;
    @Value("${hibernate.dialect}")
    private String dialect;
    @Value("${hibernate.package.scan}")
    private String packageScan;
    @Value("${liquibase.contexts}")
    private String liquibaseContexts;
    @Value("${liquibase.classpath}")
    private String liquibaseClassPath;

    @Bean
    @DependsOn("liquibase")
    public SessionFactory sessionFactory(DataSource dataSource) throws IOException {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan(packageScan);
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", ddl);
        hibernateProperties.setProperty("hibernate.dialect", dialect);
        sessionFactory.setHibernateProperties(hibernateProperties);
        sessionFactory.afterPropertiesSet();
        return sessionFactory.getObject();
    }

    @Bean
    public PlatformTransactionManager hibernateTransactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory);
        return transactionManager;
    }

    @Bean
    public DataSource dataSource() {
        BasicDataSource datasource = new BasicDataSource();
        datasource.setUrl(databaseUrl);
        datasource.setUsername(databaseUser);
        datasource.setPassword(databasePassword);
        datasource.setDriverClassName(databaseDriver);
        return datasource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean
    public SpringLiquibase liquibase(DataSource dataSource) {
        var liquibase = new SpringLiquibase();
        liquibase.setDataSource(dataSource);
        liquibase.setContexts(liquibaseContexts);
        liquibase.setChangeLog(liquibaseClassPath);
        return liquibase;
    }

}


