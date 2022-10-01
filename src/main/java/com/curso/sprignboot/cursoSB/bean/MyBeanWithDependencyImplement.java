package com.curso.sprignboot.cursoSB.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWithDependency() {
        int number = 3;
        
        System.out.println("Hello from the implementation of a bean with dependency");
        System.out.println(myOperation.sum(number));
    }
}
