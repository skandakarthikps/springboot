package com.dutta.sai.power.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DpsDiscoverServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpsDiscoverServerApplication.class, args);
	}

}
