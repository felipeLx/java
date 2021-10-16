package com.angular.javaWithAngular;

import com.angular.javaWithAngular.entity.User;
import com.angular.javaWithAngular.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.GsonBuilderUtils;

import java.util.stream.Stream;

@SpringBootApplication
public class JavaWithAngularApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaWithAngularApplication.class, args);
	}

	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("Ha", "Re", "Mi", "Fá").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}
}
