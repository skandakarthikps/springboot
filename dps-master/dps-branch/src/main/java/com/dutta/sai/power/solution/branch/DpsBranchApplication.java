package com.dutta.sai.power.solution.branch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigurationProperties
public class DpsBranchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpsBranchApplication.class, args);
	}

}
