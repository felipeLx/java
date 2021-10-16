package com.partyFind.app;

import com.partyFind.app.entity.Customer;
import com.partyFind.app.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AppApplication implements CommandLineRunner {

	@Autowired
	private CustomerRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		repository.deleteAll();

		repository.save(new Customer("Festa na Barra", "Barra da Tijuca", "Rio de Janeiro", "RJ", "Casa de Festa", "festanabarra@gmail.com"));
		repository.save(new Customer("Docinhos do céu", "Botafogo", "Rio de Janeiro", "RJ", "Serviços para festa", "festanservico@gmail.com"));

		System.out.println("Customer found with findAll():");
		System.out.println("-----------------");
		for (Customer customer: repository.findAll()) {
			System.out.println(customer);
		}
		System.out.println();

		System.out.println("Customer found with findByName('Festa na Barra'):");
		System.out.println("-----------");
		System.out.println(repository.findByBusinessName("Festa na Barra"));

		System.out.println("Customer found with findByBusinessType('Serviços para festa'):");
		System.out.println("-----------");
		System.out.println(repository.findByBusinessType("Serviços para festa"));
	}
}
