package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.loan.LoanAccountResponseDTO;
import com.mambu.bancomambu.model.transaction.FilterCriteriaDTO;
import com.mambu.bancomambu.model.transaction.RequestTransactionDTO;
import com.mambu.bancomambu.model.transaction.SortingCriteriaDTO;
import com.mambu.bancomambu.service.active.SearchTransactionLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class SearchTransactionLoanServiceIml implements SearchTransactionLoanService {

    @Autowired
    private MambuConfig mambuConfig;
    @Autowired
    private HeaderConfig headerConfig;

    @Override
    public Flux<LoanAccountResponseDTO> searchTransactionPay(String offset, String limit, String paginationDetails,
                                                             String detailsLevel, RequestTransactionDTO requestTransactionDTO) {

        return mambuConfig.getClient().post()
                .uri(uriBuilder -> uriBuilder
                        .path("/loans/transactions:search")
                        .queryParam("offset", offset)
                        .queryParam("limit", limit)
                        .queryParam("paginationDetails", paginationDetails)
                        .queryParam("detailsLevel", detailsLevel)
                        .build())
                .body(Mono.just(requestTransactionDTO), RequestTransactionDTO.class)
                .header("Accept", headerConfig.headerCreate().getAccept())
                .header("Content-Type", headerConfig.headerCreate().getContentType())
                .retrieve()
                .bodyToFlux(LoanAccountResponseDTO.class)
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
