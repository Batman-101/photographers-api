package com.excel.studio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.scheduling.annotation.EnableAsync;


@SpringBootApplication
@EnableAsync
public class PhotographerServicesApi extends SpringBootServletInitializer implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(PhotographerServicesApi.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(PhotographerServicesApi.class);
	}

	public void run(String... args) throws Exception {
		//nothing to run
	}

}
