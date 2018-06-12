package com.baiyu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author baiyu
 * @description: DataSourceConfig
 * @date: 2018/6/12
 */
@Configuration
@MapperScan(basePackages = "com.baiyu.mapper")
@PropertySource("classpath:dataSource.properties")
public class DataSourceConfig {

    @Value("${mybatis.config-location}")
    protected Resource configLocation;

    @Value("${mybatis.type-aliases-package}")
    protected String typeAliasesPackage;

    @Value("${mybatis.config-location}")
    protected String mapperLocations;

    @Bean(name = "dataSource")
    @ConfigurationProperties("spring.datasource.druid")
    public DataSource initDataSource(){
        return DruidDataSourceBuilder.create().build();
    }

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource) throws Exception {
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage(typeAliasesPackage);
        sessionFactory.setConfigLocation(configLocation);
        //添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        String[] mapperLocation = mapperLocations.split(",");
        List<Resource> lisResource = new ArrayList<Resource>();
        for (String s : mapperLocation) {
            lisResource.addAll(Arrays.asList(resolver.getResources(s)));
        }
        sessionFactory.setMapperLocations(lisResource.toArray(new Resource[mapperLocation.length]));
        return sessionFactory.getObject();
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

}
