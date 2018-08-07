package com.example.sbjt.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @auth: Created by zk on 2018/7/12
 * @description:
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {




    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter();
        MappingJackson2HttpMessageConverter jackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter();
        List<MediaType> types = new ArrayList<>();

        types.add(MediaType.APPLICATION_JSON);
        types.add(MediaType.parseMediaType("text/json;charset=utf-8"));
        jackson2HttpMessageConverter.setSupportedMediaTypes(types);

        converters.add(stringHttpMessageConverter);
        converters.add(jackson2HttpMessageConverter);
    }
}
