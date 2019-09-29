package net.frischware.javademo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

@Slf4j
@RestController
public class ResilienceController {

    private int counter=0;

    @RequestMapping("/retry")
    public ResponseEntity<String> retry() {
        counter++;
        log.info("counter: {}", counter);

        if(counter >=2) {
            log.info("Error send");
            throw new HttpServerErrorException(HttpStatus.INTERNAL_SERVER_ERROR, "This is a remote exception");
        } else {
            log.info("ok send");
            return new ResponseEntity(HttpStatus.OK);
        }

    }

    @RequestMapping("/reset")
    public ResponseEntity<String> reset() {
        counter = 0;
        log.info("counter resetted.");
        return new ResponseEntity(HttpStatus.OK);
    }

}
