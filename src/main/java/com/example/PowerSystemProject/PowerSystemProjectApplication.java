package com.example.PowerSystemProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;


@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Cloud Based Energy Provider System", version = "1.0", description = "Virtual Power Plant System"))
public class PowerSystemProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(PowerSystemProjectApplication.class, args);
	}
	

}
