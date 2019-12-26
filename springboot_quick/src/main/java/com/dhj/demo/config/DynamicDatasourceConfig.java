package com.dhj.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author DHJ
 * @date 2019-01-10 15:08
 */
public class DynamicDatasourceConfig {

    /**
     * 精确到 cluster 目录，以便跟其他数据源隔离
     */
    static final String SHT_PACKAGE = "com.dhj.demo.mapper.sht";
    static final String SHT_LOCATION = "classpath:mapper/sht/*Mapper.xml";
    /**
     * 精确到 center 目录，以便跟其他数据源隔离
     */
    static final String CENTER_PACKAGE = "com.dhj.demo.mapper.center";
    static final String CENTER_LOCATION = "classpath:mapper/center/*Mapper.xml";

    @Configuration
    @MapperScan(basePackages = SHT_PACKAGE, sqlSessionFactoryRef = "masterSqlSessionFactory", sqlSessionTemplateRef = "masterSqlSessionTemplate")
    public static class Master {
        @Primary
        @Bean(name = "masterDataSource")
        @Qualifier("masterDataSource")
        @ConfigurationProperties(prefix = "spring.datasource.sht")
        public DataSource dataSource() {
            return new DruidDataSource();
        }

        @Primary
        @Bean("masterSqlSessionFactory")
        @Qualifier("masterSqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("masterDataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(SHT_LOCATION));
            return factoryBean.getObject();
        }

        @Primary
        @Bean("masterTransactionManager")
        @Qualifier("masterTransactionManager")
        public DataSourceTransactionManager transactionManager(@Qualifier("masterDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Primary
        @Bean("masterSqlSessionTemplate")
        @Qualifier("masterSqlSessionTemplate")
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("masterSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }

    }

    @Configuration
    @MapperScan(basePackages = CENTER_PACKAGE, sqlSessionFactoryRef = "slaveSqlSessionFactory", sqlSessionTemplateRef = "slaveSqlSessionTemplate")
    public static class Slave {
        @Bean("slaveDataSource")
        @Qualifier("slaveDataSource")
        @ConfigurationProperties(prefix = "spring.datasource.center")
        public DataSource dataSource() {
            return new DruidDataSource();
        }

        @Bean("slaveSqlSessionFactory")
        @Qualifier("slaveSqlSessionFactory")
        public SqlSessionFactory sqlSessionFactory(@Qualifier("slaveDataSource") DataSource dataSource) throws Exception {
            SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
            factoryBean.setDataSource(dataSource);
            factoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(CENTER_LOCATION));
            return factoryBean.getObject();
        }

        @Bean("slaveTransactionManager")
        @Qualifier("slaveTransactionManager")
        public DataSourceTransactionManager transactionManager(@Qualifier("slaveDataSource") DataSource dataSource) {
            return new DataSourceTransactionManager(dataSource);
        }

        @Bean("slaveSqlSessionTemplate")
        @Qualifier("slaveSqlSessionTemplate")
        public SqlSessionTemplate sqlSessionTemplate(@Qualifier("slaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory) {
            return new SqlSessionTemplate(sqlSessionFactory);
        }
    }

}