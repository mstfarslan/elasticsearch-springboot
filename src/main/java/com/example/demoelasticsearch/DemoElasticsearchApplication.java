package com.example.demoelasticsearch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@SpringBootApplication
@EnableElasticsearchRepositories
public class DemoElasticsearchApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoElasticsearchApplication.class, args);
	}

}
