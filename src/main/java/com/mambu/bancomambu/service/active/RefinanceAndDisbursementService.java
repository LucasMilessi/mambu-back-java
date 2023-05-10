package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.DisbursementDTO;
import com.mambu.bancomambu.model.loan.RefinanceDTO;
import reactor.core.publisher.Mono;

public interface RefinanceAndDisbursementService {

    Mono<DisbursementDTO> refinanceAndDisbursement(String id, RefinanceDTO refinanceDTO);
}
