package com.euvic.dbcopy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DatabaseExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseExerciseApplication.class, args);
	}

}
