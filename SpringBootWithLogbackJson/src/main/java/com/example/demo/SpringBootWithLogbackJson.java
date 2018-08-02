package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static net.logstash.logback.argument.StructuredArguments.*;

@SpringBootApplication
public class SpringBootWithLogbackJson {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootWithLogbackJson.class, args);
		
		// https://github.com/logstash/logstash-logback-encoder
		Logger logger = LoggerFactory.getLogger("BootstepperApplication");
	
		String corId= "123-456-789";
		
		logger.info("foo: {}", keyValue("correlation-id", corId));
		
		Exception e = new NullPointerException("nPe");
		logger.info("Fehler: {}", "oops", e);
	}
}
