
package com.dutta.sai.power.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class DpsMainApiApplication {

	public static void main(String[] args) {

		SpringApplication.run(DpsMainApiApplication.class, args);
	}
}
