package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.transaction.TransactionDTO;
import com.mambu.bancomambu.service.passive.GetLastMovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class GetLastMovementServiceImpl implements GetLastMovementService {

    @Autowired
    private MambuConfig mambuConfig;

    @Autowired
    private HeaderConfig headerConfig;

    @Override
    public Flux<TransactionDTO> getLastTransactions(String id, String limit, String detailsLevel){

            return mambuConfig.getClient().get()
                    .uri( url -> url
                            .path("/deposits/"+id+"/transactions")
                            .queryParam("offset", "0")
                            .queryParam("limit", limit)
                            .queryParam("paginationDetails", "OFF")
                            .queryParam("detailsLevel", detailsLevel)
                            .build())
                    .header("Accept", headerConfig.headerCreate().getAccept())
                    .retrieve()
                    .bodyToFlux(TransactionDTO.class)
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
