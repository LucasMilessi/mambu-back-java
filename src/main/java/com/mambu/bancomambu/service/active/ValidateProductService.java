package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.RefinanceDTO;
import com.mambu.bancomambu.model.loan.RescheduleDTO;
import com.mambu.bancomambu.model.loan.ResponseAccountDTO;
import reactor.core.publisher.Mono;

public interface ValidateProductService {
    Mono<ResponseAccountDTO> validateRefinance(String id, RefinanceDTO refinanceDTO);

    Mono<ResponseAccountDTO> validateReschedule(String id, RescheduleDTO rescheduleDTO);
}
