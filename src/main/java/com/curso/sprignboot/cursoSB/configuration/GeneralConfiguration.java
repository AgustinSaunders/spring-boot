package com.curso.sprignboot.cursoSB.configuration;

import com.curso.sprignboot.cursoSB.Pojo.UserPojo;
import com.curso.sprignboot.cursoSB.bean.PropertiesBean;
import com.curso.sprignboot.cursoSB.bean.PropertiesBeanImplements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableConfigurationProperties(UserPojo.class)
public class GeneralConfiguration {
    @Value("${value.name}")
    private String name;

    @Value("${value.surname}")
    private String surname;

    @Value("${value.random}")
    private String random;

    @Bean
    public PropertiesBean function(){
        return new PropertiesBeanImplements(name, surname);
    }

    @Bean
    public DataSource dataSource(){
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.driverClassName("org.h2.Driver");
        dataSourceBuilder.url("jdbc:h2:mem:test;NON_KEYWORDS=USER");
        dataSourceBuilder.username("SA");
        dataSourceBuilder.password("");
        return dataSourceBuilder.build();
    }
}
