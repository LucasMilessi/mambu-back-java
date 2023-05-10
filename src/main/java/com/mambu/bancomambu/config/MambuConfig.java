package com.mambu.bancomambu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class MambuConfig {

    @Autowired
    private HeaderConfig headerConfig;

    @Bean
    public WebClient getClient() {

        return WebClient.builder()
                .baseUrl(headerConfig.headerCreate().getUrlMambu())
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeaders(head -> head.setBasicAuth(headerConfig.headerCreate().getUserName(),
                        headerConfig.headerCreate().getPassword()))
                .build();
    }
}
