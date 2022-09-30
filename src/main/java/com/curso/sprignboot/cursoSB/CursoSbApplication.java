package com.curso.sprignboot.cursoSB;

import com.curso.sprignboot.cursoSB.beam.MyBean;
import com.curso.sprignboot.cursoSB.beam.MyBeanWithDependency;
import com.curso.sprignboot.cursoSB.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoSbApplication implements CommandLineRunner {
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private ComponentDependency componentDependency;
	//We have two classes which implements the same dependency
	//So this will generate an error unless we specify which class we want to use
	//For this we need to use the annotation @Qualifier
	//followed by the name of the class we are going to use but in lower camel case
	public CursoSbApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
							  MyBean myBean, MyBeanWithDependency myBeanWithDependency){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
	}


	public static void main(String[] args) {
		SpringApplication.run(CursoSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
	}
}
