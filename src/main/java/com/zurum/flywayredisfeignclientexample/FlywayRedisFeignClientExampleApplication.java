package com.zurum.flywayredisfeignclientexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FlywayRedisFeignClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywayRedisFeignClientExampleApplication.class, args);
	}

}
