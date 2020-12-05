package com.avi;

import com.avi.model.Contact;
import com.avi.repository.ContactRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.LongStream;

@SpringBootApplication
public class AviApplication {

	public static void main(String[] args) {
		SpringApplication.run(AviApplication.class, args);
		System.out.println("Application started");
	}

	@Bean
	CommandLineRunner init(ContactRepository repository) {
		System.out.println("Loading contacts");
		return args -> {
			repository.deleteAll();
			LongStream.range(1, 11)
					.mapToObj(i -> new Contact(i, "Avi " + i, "Jain " + i, "avi" + i + "@email.com", "1234567890", "Active"))
					.map(v -> repository.save(v))
					.forEach(System.out::println);
		};

	}
}
