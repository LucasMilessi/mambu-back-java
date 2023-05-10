package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.interest.InterestDTO;
import com.mambu.bancomambu.service.passive.ApplyInterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class ApplyInterestServiceImpl implements ApplyInterestService {

    @Autowired
    private MambuConfig mambuConfig;
    @Autowired
    private HeaderConfig headerConfig;

    @Override
    public Mono<Object> applyInterest(String id, InterestDTO interestDTO) {

            return mambuConfig.getClient().post()
                    .uri(uriBuilder -> uriBuilder
                            .path("/deposits/"+ id +":applyInterest")
                            .build())
                    .body(Mono.just(interestDTO), InterestDTO.class)
                    .header("Accept", headerConfig.headerCreate().getAccept())
                    .header("IdempotencyKey", headerConfig.headerCreate().getIdempotencyKey())
                    .header("Content-Type", headerConfig.headerCreate().getContentType())
                    .exchangeToMono(res -> Mono.empty())
                    .onErrorComplete()
                    .onErrorResume(e -> {
                        var responseException = (WebClientResponseException) e;
                        if (e instanceof WebClientResponseException) {
                            if (responseException.getStatusCode().is4xxClientError()) {
                                if(responseException.getStatusCode().value() == 400){
                                    return Mono.error(new Throwable(BAD_REQUEST.getDescription()+" "+
                                            responseException.getResponseBodyAsString()));
                                }else if (responseException.getStatusCode().value() == 401){
                                    return Mono.error(new Throwable(UNAUTHORIZED.getDescription()+" "+
                                            responseException.getResponseBodyAsString()));
                                }else if (responseException.getStatusCode().value() == 403){
                                    return Mono.error(new Throwable(FORBIDDEN.getDescription()+" "+
                                            responseException.getResponseBodyAsString()));
                                }else if (responseException.getStatusCode().value() == 404){
                                    return Mono.error(new Throwable(NOT_FOUND.getDescription()+" "+
                                            responseException.getResponseBodyAsString()));
                                }
                                return Mono.error(new Throwable(responseException.getResponseBodyAsString()));
                            }
                        }
                        return Mono.error(new Throwable(responseException.getResponseBodyAsString()));
                    });
    }
}
