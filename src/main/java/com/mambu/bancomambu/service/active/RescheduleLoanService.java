package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.RescheduleDTO;
import com.mambu.bancomambu.model.loan.ResponseAccountDTO;
import reactor.core.publisher.Mono;

public interface RescheduleLoanService {
    Mono<ResponseAccountDTO> rescheduleLoan(String id, RescheduleDTO rescheduleDTO);
}
