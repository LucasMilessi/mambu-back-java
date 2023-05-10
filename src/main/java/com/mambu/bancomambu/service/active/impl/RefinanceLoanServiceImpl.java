package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.loan.RefinanceDTO;
import com.mambu.bancomambu.model.loan.ResponseAccountDTO;
import com.mambu.bancomambu.service.active.RefinanceLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class RefinanceLoanServiceImpl implements RefinanceLoanService {

    @Autowired
    private MambuConfig mambuConfig;

    @Autowired
    private HeaderConfig headerConfig;

    private final String DESCRIPTIONREFINANCE = "Se refinanció y se abrió una nueva cuenta con el siguiente identificador: ";

    @Override
    public Mono<ResponseAccountDTO> refinanceLoan(String id, RefinanceDTO refinanceDTO) {



        return mambuConfig.getClient().post()
                .uri("/loans/"+id+":refinance")
                .body(Mono.just(refinanceDTO), RefinanceDTO.class)
                .header("Accept", headerConfig.headerCreate().getAccept())
                .header("Idempotency-Key", UUID.randomUUID().toString().substring(0, 36))
                .header("Content-Type", headerConfig.headerCreate().getContentType())
                .retrieve()
                .bodyToMono(ResponseAccountDTO.class).map( response -> {
                    response.setDescription(DESCRIPTIONREFINANCE + response.getId());
                    return response;
                })
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
