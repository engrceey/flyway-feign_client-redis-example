package com.zurum.flywayredisfeignclientexample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableFeignClients
@SpringBootApplication
@EnableRedisHttpSession
public class FlywayRedisFeignClientExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlywayRedisFeignClientExampleApplication.class, args);
	}

}
