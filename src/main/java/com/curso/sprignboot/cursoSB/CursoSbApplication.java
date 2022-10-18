package com.curso.sprignboot.cursoSB;

import com.curso.sprignboot.cursoSB.Pojo.UserPojo;
import com.curso.sprignboot.cursoSB.bean.MyBean;
import com.curso.sprignboot.cursoSB.bean.MyBeanWithDependency;
import com.curso.sprignboot.cursoSB.bean.PropertiesBean;
import com.curso.sprignboot.cursoSB.component.ComponentDependency;
import com.curso.sprignboot.cursoSB.entity.User;
import com.curso.sprignboot.cursoSB.repository.UserRepository;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CursoSbApplication implements CommandLineRunner {

	private final org.apache.juli.logging.Log LOGGER = LogFactory.getLog(CursoSbApplication.class);
	private MyBean myBean;
	private PropertiesBean propertiesBean;
	private MyBeanWithDependency myBeanWithDependency;
	private ComponentDependency componentDependency;
	private UserRepository userRepository;
	private UserPojo userPojo;
	//We have two classes which implements the same dependency
	//So this will generate an error unless we specify which class we want to use
	//For this we need to use the annotation @Qualifier
	//followed by the name of the class we are going to use but in lower camel case
	public CursoSbApplication(@Qualifier("componentTwoImplement") ComponentDependency componentDependency,
							  MyBean myBean, MyBeanWithDependency myBeanWithDependency,
							  PropertiesBean propertiesBean, UserPojo userPojo, UserRepository userRepository){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.propertiesBean = propertiesBean;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
	}


	public static void main(String[] args) {
		SpringApplication.run(CursoSbApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		//pastExamples();
		saveUsersInDataBase();
		getInformationJpqlFromUser();
	}

	private void getInformationJpqlFromUser(){
		LOGGER.info("User with the method findByUserEmail" +
				userRepository.findByUserEmail("minotaur@domain.com"));

		userRepository.findAndSort("Asterio", Sort.by("id").descending())
				.forEach(user -> LOGGER.info("User with sort method" + user));

		userRepository.findByName("John")
				.forEach(LOGGER::info);

		LOGGER.info("The parameters you gave us thorow: " +
		userRepository.getAllByBirthDateAndEmail(LocalDate.of(2017, 4, 25),
				"jean@domain.com")
				.orElseThrow(() -> new RuntimeException("User not found")));
	}
	private void saveUsersInDataBase(){
		User user1 = new User("John", "john@domain.com",
				LocalDate.of(2021, 3, 20));
		User user2 = new User("Dominic", "dominic@domain.com",
				LocalDate.of(2021, 1, 7));
		User user3 = new User("Jean", "jean@domain.com",
				LocalDate.of(2017, 4, 25));
		User user4 = new User("Abelardo", "abelardo@domain.com",
				LocalDate.of(2015, 12, 7));
		User user5 = new User("Asterios", "minotaur@domain.com",
				LocalDate.of(2004, 4, 30));
		User user6 = new User("Asterios1", "youngminotaur@domain.com",
				LocalDate.of(2004, 5, 1));
		User user7 = new User("Asterios0", "oldminotaur@domain.com",
				LocalDate.of(2004, 4, 29));

		List<User> list = Arrays.asList(user1,user2, user3, user4, user5, user6, user7);
		list.stream().forEach(userRepository::save);
	}

	private void pastExamples(){
		componentDependency.greet();
		myBean.print();
		myBeanWithDependency.printWithDependency();
		System.out.println(propertiesBean.function());
		System.out.println(userPojo.getEmail() + "-" + userPojo.getAge());
		LOGGER.error("FATAL ERROR, ALL YOUR INFORMATION WAS DELIVERED TO THE NSA");
	}
}
