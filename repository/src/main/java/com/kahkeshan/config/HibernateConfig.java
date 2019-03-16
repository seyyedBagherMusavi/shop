package com.kahkeshan.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/* com.me.config
@Author:Peyman
Date: 14/02/2019
Time: 10:41 AM
Year: 2019
*/
@Configuration
@EnableTransactionManagement
@PropertySource({
        "classpath:database.properties"
})
@ComponentScan(basePackages = { "com.kahkeshan" })
public class HibernateConfig {

    @Autowired
    private Environment environment;
   /*  @Bean
     @Autowired
     public DataSourceTransactionManager transactionManager(DataSource ds) {
     DataSourceTransactionManager txManager = new DataSourceTransactionManager();
     txManager.setDataSource(ds);
     return txManager;
     }*/


    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com.kahkeshan.entities"});
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(environment.getRequiredProperty("jdbc.driverClassName"));
        dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
        dataSource.setUsername(environment.getRequiredProperty("jdbc.username"));
        dataSource.setPassword(environment.getRequiredProperty("jdbc.password"));
        return dataSource;
    
    }
    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty("hibernate.dialect", environment.getRequiredProperty("hibernate.dialect"));
        hibernateProperties.setProperty("hibernate.show_sql", environment.getRequiredProperty("hibernate.show_sql"));
        hibernateProperties.setProperty("hibernate.format_sql", environment.getRequiredProperty("hibernate.format_sql"));
        hibernateProperties.setProperty("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
        hibernateProperties.setProperty(
                "hibernate.connection.CharSet", environment.getRequiredProperty("hibernate.connection.CharSet"));
        hibernateProperties.setProperty(
                "hibernate.connection.characterEncoding", environment.getRequiredProperty("hibernate.connection.characterEncoding"));
        hibernateProperties.setProperty(
                "hibernate.connection.useUnicode", environment.getRequiredProperty("hibernate.connection.useUnicode"));


        return hibernateProperties;
    }
    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
