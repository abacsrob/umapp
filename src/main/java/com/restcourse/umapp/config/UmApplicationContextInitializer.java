package com.restcourse.umapp.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@Slf4j
public class UmApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
    public UmApplicationContextInitializer() {
    }

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        final ConfigurableEnvironment environment = applicationContext.getEnvironment();
        final String activeProfiles = environment.getProperty("spring.profiles.active");

        if (activeProfiles != null) {
            log.info("The active profiles are: {}", activeProfiles);
            environment.setActiveProfiles(activeProfiles.split(","));
        } else {
            log.info("There are no active profiles.");
        }
    }
}
