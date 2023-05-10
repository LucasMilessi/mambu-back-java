package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.InterestRateDTO;
import reactor.core.publisher.Mono;

public interface AnalyzeAccountService {
    Mono<Object> analyzeAccount(String id, InterestRateDTO interestRateDTO);
}
