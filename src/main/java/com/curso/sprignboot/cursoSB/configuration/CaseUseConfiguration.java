package com.curso.sprignboot.cursoSB.configuration;


import com.curso.sprignboot.cursoSB.caseUse.GetUser;
import com.curso.sprignboot.cursoSB.caseUse.GetUserImplement;
import com.curso.sprignboot.cursoSB.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;

@Configuration
public class CaseUseConfiguration {
    @RequestMapping
    @Bean
    GetUser getUser(UserService userService){
        return new GetUserImplement(userService);
    }
}
