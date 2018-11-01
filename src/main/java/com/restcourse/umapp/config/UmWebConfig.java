package com.restcourse.umapp.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan({ "com.restcourse.umapp.web" })
@EnableWebMvc
public class UmWebConfig extends WebMvcConfigurerAdapter {
}
