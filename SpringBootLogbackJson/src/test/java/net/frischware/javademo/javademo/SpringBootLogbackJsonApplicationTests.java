package net.frischware.javademo.javademo;

import io.vavr.collection.Stream;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Random;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootLogbackJsonApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Test
	public void testDelete() throws InterruptedException {
		HashMap<Integer,String> map;

		int idx=0;
		map = new HashMap<Integer, String>();
		map.put(idx++, "this is a logback test");
		map.put(idx++, "Most Java logging libraries today offer different layout options for formatting logs – to accurately fit the needs of each project.");
		map.put(idx++, "Then, in our log4j2.xml file, we can create a new Appender that uses JsonLayout and a new Logger that uses this Appender:");
		map.put(idx++, "So, let's see how to configure it to get the output of the logs in JSON format");
		map.put(idx++, "First, we create a new appender in our logback.xml that uses JsonLayout and JacksonJsonFormatter.");


		for ( int i = 1; i <= 24; i++ ) {
			log.info( map.get(getRandomNumberInRange(0,5)));
			try {
				Thread.sleep( 10000L );
			} catch ( final InterruptedException e ) {
				log.error( "an error occurred", e );
			}
		};

		//System.out.println("sleep 5000ms now...");
		//Thread.sleep(5000);
	}


	private static int getRandomNumberInRange(int min, int max) {
		Random r = new Random();
		return r.ints(min, (max + 1)).findFirst().getAsInt();

	}
}
