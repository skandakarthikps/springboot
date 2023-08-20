
package com.dutta.sai.power.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigurationProperties
@EnableEurekaClient
public class DpsEmployeeApplication {

	public static void main(String[] args) {

		SpringApplication.run(DpsEmployeeApplication.class, args);
	}
}
