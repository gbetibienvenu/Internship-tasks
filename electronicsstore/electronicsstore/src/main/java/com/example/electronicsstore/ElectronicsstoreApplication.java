package com.example.electronicsstore;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import java.io.PrintStream;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.electronicsstore.repository")
@EntityScan(basePackages = "com.example.electronicsstore.model") // If the @EntityScan annotation is missing
public class ElectronicsstoreApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ElectronicsstoreApplication.class);

		// Custom banner
		app.setBanner(new Banner() {
			@Override
			public void printBanner(org.springframework.core.env.Environment environment,
									Class<?> sourceClass, PrintStream out) {
				out.println("**********************************************");
				out.println("      Welcome to the Electronics Store!      ");
				out.println("**********************************************");
				out.println("  Your one-stop shop for all electronic goods.");
				out.println("**********************************************");
			}
		});

		app.run(args);  // Run the Spring Boot application
	}
}











//package com.example.electronicsstore;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
//import org.springframework.boot.Banner;
//import java.io.PrintStream;
//
//@SpringBootApplication
//@EnableJpaRepositories(basePackages = "com.example.electronicsstore.repository")
//@EntityScan(basePackages = "com.example.electronicsstore.model") // If the @EntityScan annotation is missing
//public class ElectronicsstoreApplication {
//	public static void main(String[] args) {
//		SpringApplication.run(ElectronicsstoreApplication.class, args);
//	}
//}












//package com.example.electronicsstore;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class ElectronicsstoreApplication {
//
//	public static void main(String[] args) {
//		SpringApplication.run(ElectronicsstoreApplication.class, args);
//	}
//
//}
