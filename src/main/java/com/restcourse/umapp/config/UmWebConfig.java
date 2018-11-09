package com.restcourse.umapp.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;
import java.util.Optional;

@Configuration
@ComponentScan({ "com.restcourse.umapp.web" })
@EnableWebMvc
public class UmWebConfig extends WebMvcConfigurerAdapter {

    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        Optional<HttpMessageConverter<?>> jsonConverterOptional = converters.stream().filter(converter -> converter instanceof MappingJackson2HttpMessageConverter).findFirst();
        jsonConverterOptional.ifPresent(converter -> {
            final AbstractJackson2HttpMessageConverter jsonConverter = (AbstractJackson2HttpMessageConverter) converter;
            jsonConverter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            jsonConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        });
        Optional<HttpMessageConverter<?>> xmlConverterOptional = converters.stream().filter(converter -> converter instanceof MappingJackson2XmlHttpMessageConverter).findFirst();
        xmlConverterOptional.ifPresent(converter -> {
            final AbstractJackson2HttpMessageConverter xmlConverter = (AbstractJackson2HttpMessageConverter) converter;
            xmlConverter.getObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);
            xmlConverter.getObjectMapper().enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        });
    }

//    @Bean
    public javax.validation.Validator localValidatorFactoryBean() {
        return new LocalValidatorFactoryBean();
    }
}
