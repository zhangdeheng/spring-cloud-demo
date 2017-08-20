package com.rainierSoft.vireurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
@EnableEurekaServer
@SpringBootApplication
public class VirEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirEurekaServerApplication.class, args);
	}
}
 