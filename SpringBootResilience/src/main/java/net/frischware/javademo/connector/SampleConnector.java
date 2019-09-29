package net.frischware.javademo.connector;

import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.retry.configure.RetryConfigurationProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Retry(name = "connector")
@Component
public class SampleConnector {

    private static final String URL  = "http://localhost:9000/retry";

    @Autowired
    RetryConfigurationProperties conf;


    public String callServer() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(URL, String.class);
        log.info("Server called...");
        conf.getConfigs().forEach( (k, v)-> log.info("  CONFIGS::key={}, val={}", k,v) );
        conf.getInstances().forEach( (k, v)-> log.info("  INSTANCES::key={}, val={}", k,v) );
        conf.getBackends().forEach( (k, v)-> log.info("  BACKENDS::key={}, val={}", k,v) );

        return response.getBody();
    }

}
