package com.curso.sprignboot.cursoSB.bean;

public class PropertiesBeanImplements implements PropertiesBean{

    private String name;
    private String surname;

    public PropertiesBeanImplements(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    @Override
    public String function() {
        return name + " - " + surname;
    }
}
