package com.mambu.bancomambu.config;

import com.mambu.bancomambu.model.global.HeaderDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HeaderConfig {
    @Bean
    public HeaderDTO headerCreate(){
        return new HeaderDTO();
    }
}
