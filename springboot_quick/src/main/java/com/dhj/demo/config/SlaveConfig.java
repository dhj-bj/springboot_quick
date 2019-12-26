package com.dhj.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.orm.jpa.JpaProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.sql.DataSource;
import java.util.Map;

/**
 * Created by QinHe on 2018-07-24.
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactorySlave",
        transactionManagerRef = "transactionManagerSlave",
        basePackages = {"com.dhj.demo.dao.center"}) //设置Repository所在位置
public class SlaveConfig {

    @Resource(name = "slaveDataSource")
    private DataSource slaveDruidDataSource;

    @Autowired
    private JpaProperties jpaProperties;

    @Bean(name = "entityManagerFactorySlave")
    public LocalContainerEntityManagerFactoryBean entityManagerFactorySlave(EntityManagerFactoryBuilder builder) {
        LocalContainerEntityManagerFactoryBean slavePersistenceUnit = builder
                .dataSource(slaveDruidDataSource)
                .properties(getVendorProperties(slaveDruidDataSource))
                .packages("com.dhj.demo.pojo.center") //设置实体类所在位置
                .persistenceUnit("slavePersistenceUnit")
                .build();
        slavePersistenceUnit.getJpaPropertyMap().remove("hibernate.hbm2ddl.auto");
        return slavePersistenceUnit;
    }

    @Bean(name = "entityManagerSlave")
    public EntityManager entityManagerSlave(EntityManagerFactoryBuilder builder) {
        return entityManagerFactorySlave(builder).getObject().createEntityManager();
    }

    private Map<String, String> getVendorProperties(DataSource dataSource) {
        return jpaProperties.getHibernateProperties(dataSource);
    }

    @Bean(name = "transactionManagerSlave")
    public PlatformTransactionManager transactionManagerSlave(EntityManagerFactoryBuilder builder) {
        return new JpaTransactionManager(entityManagerFactorySlave(builder).getObject());
    }

}


