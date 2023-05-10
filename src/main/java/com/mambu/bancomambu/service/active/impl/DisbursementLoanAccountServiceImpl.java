package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.loan.DisbursementDTO;
import com.mambu.bancomambu.model.loan.LoanDTO;
import com.mambu.bancomambu.service.active.DisbursementLoanAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class DisbursementLoanAccountServiceImpl implements DisbursementLoanAccountService {

    @Autowired
    private MambuConfig mambuConfig;
    @Autowired
    private HeaderConfig headerConfig;

    private final String NOTE = "Se aplico el desembolso";

    @Override
    public Mono<DisbursementDTO> disbursementLoanAccount(String loanAccountId) {

        var disbursementDTO = DisbursementDTO.builder().note(NOTE).build();

        return mambuConfig.getClient().post()
                .uri("/loans/"+loanAccountId+"/disbursement-transactions")
                .body(Mono.just(disbursementDTO), DisbursementDTO.class)
                .header("Accept", headerConfig.headerCreate().getAccept())
                .header("Idempotency-Key", headerConfig.headerCreate().getIdempotencyKey())
                .header("Content-Type", headerConfig.headerCreate().getContentType())
                .retrieve()
                .bodyToMono(DisbursementDTO.class)
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
