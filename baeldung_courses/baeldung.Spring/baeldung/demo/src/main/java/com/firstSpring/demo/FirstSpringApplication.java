package com.firstSpring.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication(scanBasePackages = "com.firstSpring.demo.persistence")
@SpringBootApplication
public class FirstSpringApplication {


//	ProjectServiceImpl projectService;

	public static void main(final String... args) {
		SpringApplication.run(FirstSpringApplication.class, args);
	}


/*	@PostConstruct
	public void postConstructor() {
		Project project = new Project( "My First Project", LocalDate.now());
		projectService.save(project);

		Optional<Project> optionalProject = projectService.findById(1L);
		optionalProject.ifPresent(System.out::println);
	}*/
}
