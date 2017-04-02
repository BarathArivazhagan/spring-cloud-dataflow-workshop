package com.barath.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.dataflow.server.EnableDataFlowServer;

@SpringBootApplication
@EnableDataFlowServer
public class SpringCloudDataflowServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataflowServerApplication.class, args);
	}
}
