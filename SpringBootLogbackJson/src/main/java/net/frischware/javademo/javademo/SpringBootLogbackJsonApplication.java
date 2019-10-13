package net.frischware.javademo.javademo;

import static net.logstash.logback.argument.StructuredArguments.keyValue;

import io.vavr.collection.Stream;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.HashMap;
import java.util.Random;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class SpringBootLogbackJsonApplication {

	public static void main(String[] args)  {
		SpringApplication.run(SpringBootLogbackJsonApplication.class, args);

	}


	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();

	}


}
