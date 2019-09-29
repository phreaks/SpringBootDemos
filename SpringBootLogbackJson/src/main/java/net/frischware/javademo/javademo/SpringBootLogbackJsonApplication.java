package net.frischware.javademo.javademo;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootLogbackJsonApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootLogbackJsonApplication.class, args);
		
		// https://github.com/logstash/logstash-logback-encoder
		Logger logger = LoggerFactory.getLogger("SpringBootWithLogbackJson");
	
		String corId= "123-456-789";
		
		logger.info("foo: {}", keyValue("correlation-id", corId));
		
		Exception e = new NullPointerException("nPe");
		logger.info("Fehler: {}", "oops", e);
	}
}
