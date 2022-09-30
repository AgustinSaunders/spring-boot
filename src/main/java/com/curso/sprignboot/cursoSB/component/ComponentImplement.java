package com.curso.sprignboot.cursoSB.component;

import org.springframework.stereotype.Component;

import java.sql.SQLOutput;

@Component
public class ComponentImplement implements ComponentDependency{

    @Override
    public void greet() {
        System.out.println("Hello world from my component");

    }
}
