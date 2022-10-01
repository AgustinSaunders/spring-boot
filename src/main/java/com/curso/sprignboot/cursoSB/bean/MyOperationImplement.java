package com.curso.sprignboot.cursoSB.bean;

public class MyOperationImplement implements MyOperation{

    @Override
    public int sum(int number) {
        return number + 4;
    }
}
