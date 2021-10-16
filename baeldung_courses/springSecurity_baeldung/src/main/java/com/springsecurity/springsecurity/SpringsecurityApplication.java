package com.springsecurity.springsecurity;

import org.springframework.core.convert.converter.Converter;
import com.springsecurity.springsecurity.persistence.InMemoryUserRepository;
import com.springsecurity.springsecurity.persistence.UserRepository;
import com.springsecurity.springsecurity.web.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.springsecurity.springsecurity.web")
public class SpringsecurityApplication {

	@Bean
	UserRepository userRepository() {
		return new InMemoryUserRepository();
	}

	@Bean
	public Converter<String, User> messageConverter() {
		return new Converter<String, User>() {
			@Override
			public User convert(String id) {
				return userRepository().findUser(Long.valueOf(id));
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

}
