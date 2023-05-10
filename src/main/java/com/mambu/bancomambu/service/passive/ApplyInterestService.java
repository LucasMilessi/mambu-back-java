package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.interest.InterestDTO;
import reactor.core.publisher.Mono;

public interface ApplyInterestService {
    Mono<Object> applyInterest(String depositAccountId, InterestDTO interestDTO);
}
