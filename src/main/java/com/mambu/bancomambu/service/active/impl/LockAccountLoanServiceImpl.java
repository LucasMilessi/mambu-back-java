package com.mambu.bancomambu.service.active.impl;

import com.mambu.bancomambu.config.HeaderConfig;
import com.mambu.bancomambu.config.MambuConfig;
import com.mambu.bancomambu.model.loan.LockAccountLoanDTO;
import com.mambu.bancomambu.model.loan.LoanAccountResponseDTO;
import com.mambu.bancomambu.model.loan.LockResponseDTO;
import com.mambu.bancomambu.service.active.LockAccountLoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import static com.mambu.bancomambu.model.StatusResponseEnum.*;
import static com.mambu.bancomambu.model.StatusResponseEnum.NOT_FOUND;

@Service
public class LockAccountLoanServiceImpl implements LockAccountLoanService {

    @Autowired
    private MambuConfig mambuConfig;

    @Autowired
    private HeaderConfig headerConfig;

    private final String NOTE = "Cuenta de prestamo bloqueada";

    @Override
    public Mono<LockResponseDTO> blockAccountLoan(String id, LockAccountLoanDTO lockAccountLoanDTO) {

        lockAccountLoanDTO.setNotes(NOTE);

        return mambuConfig.getClient().post()
                .uri("/loans/"+id+"/lock-transactions")
                .body(Mono.just(lockAccountLoanDTO), LockAccountLoanDTO.class)
                .header("Accept", headerConfig.headerCreate().getAccept())
                .header("Content-Type", headerConfig.headerCreate().getContentType())
                .header("IdempotencyKey", headerConfig.headerCreate().getIdempotencyKey())
                .retrieve()
                .bodyToMono(LockResponseDTO.class)
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
