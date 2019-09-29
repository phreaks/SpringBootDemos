package net.frischware.javademo.controller;


import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import lombok.extern.slf4j.Slf4j;
import net.frischware.javademo.connector.SampleConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/")
public class SampleController {

    @Autowired
    SampleConnector connector;

    @Autowired
    RetryRegistry registry;

    @GetMapping("retry")
    public String retry() {
        return connector.callServer();
    }

    @GetMapping("show")
    public String show() {
        RetryConfig conf = registry.getDefaultConfig();
        return "";
    }
}

