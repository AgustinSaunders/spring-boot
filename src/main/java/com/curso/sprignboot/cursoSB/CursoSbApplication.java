package com.curso.sprignboot.cursoSB;

import com.curso.sprignboot.cursoSB.Pojo.UserPojo;
import com.curso.sprignboot.cursoSB.bean.MyBean;
import com.curso.sprignboot.cursoSB.bean.MyBeanWithDependency;
import com.curso.sprignboot.cursoSB.bean.PropertiesBean;
import com.curso.sprignboot.cursoSB.component.ComponentDependency;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoSbApplication implements CommandLineRunner {

	private final org.apache.juli.logging.Log LOGGER = LogFactory.getLog(CursoSbApplication.class);
	private MyBean myBean;
	private PropertiesBean propertiesBean;
	private MyBeanWithDependency myBeanWithDependency;
	private ComponentDependency componentDependency;
	private UserPojo userPojo;
	//We have two classes which implements the same dependency
	//So this will generate an error unless we specify which class we want to use
	//For this we need to use the annotation @Qualifier
	//followed by the name of the class we are going to use but in lower camel case
	public CursoSbApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
							  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
							  PropertiesBean propertiesBean, UserPojo userPojo){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.propertiesBean = propertiesBean;
		this.userPojo = userPojo;
	}


	public static void main(String[] args) {
		SpringApplication.run(CursoSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(propertiesBean.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getAge());
		LOGGER.error("FATAL ERROR, ALL YOUR INFORMATION WAS DELIVERED TO THE NSA");
	}
}
