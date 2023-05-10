package com.mambu.bancomambu.service.passive.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.account.BlockFundsResponseDTO;
import com.mambu.bancomambu.service.passive.AllBlockByIdAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class AllBlockByIdAccountServiceImpl implements AllBlockByIdAccountService {

    @Autowired
    private MambuConfig mambuConfig;
    @Autowired
    private HeaderConfig headerConfig;

    @Override
    public Flux<BlockFundsResponseDTO> allBlockById(String id, String offset, String limit, String paginationDetails,
                                                    String state) {

        return mambuConfig.getClient().get()
                .uri(uriBuilder -> uriBuilder
                        .path("/deposits/"+id+"/blocks")
                        .queryParam("offset", offset)
                        .queryParam("limit", limit)
                        .queryParam("paginationDetails", paginationDetails)
                        .queryParam("state", state)
                        .build())
                .header("Accept", headerConfig.headerCreate().getAccept())
                .retrieve()
                .bodyToFlux(BlockFundsResponseDTO.class)
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
