package com.curso.sprignboot.cursoSB.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTwoImplement implements ComponentDependency{
    @Override
    public void greet() {
        System.out.println("Hello World from my second component");
    }
}
