package com.cignex.book.catelog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Configuration;

@EnableHystrix
@EnableEurekaClient
@Configuration
@EnableAutoConfiguration
public class BookCatelogServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookCatelogServiceApplication.class, args);
	}
}
