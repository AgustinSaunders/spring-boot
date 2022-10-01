package com.curso.sprignboot.cursoSB.configuration;

import com.curso.sprignboot.cursoSB.bean.PropertiesBean;
import com.curso.sprignboot.cursoSB.bean.PropertiesBeanImplements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
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
}
