package com.dutta.sai.power.solution;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class DpsConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DpsConfigServerApplication.class, args);
	}

}
