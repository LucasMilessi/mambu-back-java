package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.RefinanceDTO;
import com.mambu.bancomambu.model.loan.ResponseAccountDTO;
import reactor.core.publisher.Mono;

public interface RefinanceLoanService {
    Mono<ResponseAccountDTO> refinanceLoan(String id, RefinanceDTO refinanceDTO);
}
