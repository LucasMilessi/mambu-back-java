package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.LoanDTO;
import reactor.core.publisher.Mono;

public interface ConsultantOperationService {
    Mono<LoanDTO> consultantOperationById(String id);
}
