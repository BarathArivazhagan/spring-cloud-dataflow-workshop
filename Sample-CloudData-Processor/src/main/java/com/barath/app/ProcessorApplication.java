package com.barath.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.integration.annotation.Transformer;

@SpringBootApplication
@EnableBinding(Processor.class)
public class ProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}
	
	@Transformer(inputChannel = Processor.INPUT, 
			  outputChannel = Processor.OUTPUT)
			public Object transform(Long timestamp) {
			 System.out.println("Transform is called "+timestamp);
			    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm:yy");
			    String date = dateFormat.format(timestamp);
			    return date;
			}
}
