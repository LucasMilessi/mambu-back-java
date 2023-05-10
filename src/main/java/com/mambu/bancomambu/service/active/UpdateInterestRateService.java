package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.InterestRateDTO;
import reactor.core.publisher.Mono;

public interface UpdateInterestRateService {
    Mono<Object> updateInterest(String id, InterestRateDTO interestRateDTO);
}
