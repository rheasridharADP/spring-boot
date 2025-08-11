package com.webage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;

//  PART 5c
//	Remove the exclude attribute from the annotation below:

@SpringBootApplication //(exclude = JpaRepositoriesAutoConfiguration.class)
//@SpringBootApplication
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
