package xyz.nesting.quick;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		/*
		 * 直接运行 mvn spring-boot:run
		 * 后台运行 nohup mvn spring-boot:run &
		 */
		SpringApplication.run(Application.class, args);
		
	}
	
}
