package com.cignex.shopping;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@EnableEurekaClient
@EnableHystrix
@EnableFeignClients
@SpringBootApplication
public class BookShoppingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookShoppingServiceApplication.class, args);
	}
}