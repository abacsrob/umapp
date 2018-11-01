package com.restcourse.umapp;

import com.restcourse.umapp.config.UmApplicationContextInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class UmappApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(UmappApplication.class)
                .initializers(new UmApplicationContextInitializer())
                .listeners().run(args);
    }
}
