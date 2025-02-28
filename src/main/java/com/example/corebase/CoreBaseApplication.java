package com.example.corebase;

import jakarta.annotation.PostConstruct;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.util.TimeZone;

@SpringBootApplication
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource(value = "classpath:application-${spring.profiles.active}.properties", ignoreResourceNotFound = true)
})
@EnableAspectJAutoProxy
public class CoreBaseApplication {

    private static final Logger logger = LoggerFactory.getLogger(CoreBaseApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CoreBaseApplication.class, args);
    }

    @PostConstruct
    public void init() {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Ho_Chi_Minh"));
        logger.warn("Application running in timezone: {}", TimeZone.getDefault().getID());
    }
}
