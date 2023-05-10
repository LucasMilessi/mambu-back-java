package com.mambu.bancomambu.model.global;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;

import java.util.UUID;

@Data
public class HeaderDTO {

    @Value("${user}")
    private String userName;

    @Value("${password}")
    private String password;

    @Value("${urlMambu}")
    private String urlMambu;

    @Value("${Accept}")
    private String accept;

    @Value("${ContentType}")
    private String contentType;

    private String IdempotencyKey = UUID.randomUUID().toString().substring(0, 36);
}
