package net.frischware.javademo.javademo;

import io.vavr.collection.Stream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Random;

@Slf4j
@Component
public class Tasker {

    private HashMap<Integer,String> map;

    public Tasker() {
        int idx=0;
        map = new HashMap<Integer, String>();
        map.put(idx++, "this is a logback test");
        map.put(idx++, "Most Java logging libraries today offer different layout options for formatting logs – to accurately fit the needs of each project.");
        map.put(idx++, "Then, in our log4j2.xml file, we can create a new Appender that uses JsonLayout and a new Logger that uses this Appender:");
        map.put(idx++, "So, let's see how to configure it to get the output of the logs in JSON format");
        map.put(idx++, "First, we create a new appender in our logback.xml that uses JsonLayout and JacksonJsonFormatter.");
    }

    /**
     *
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 5000)
    public void writeLogs() throws InterruptedException {
        Stream.range(0,500).forEach( v -> log.info( map.get(getRandomNumberInRange(0,5) ) ) ) ;
    }

    /**
     *
     * @param min
     * @param max
     * @return
     */
    private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.ints(min, (max + 1)).findFirst().getAsInt();

    }
}
