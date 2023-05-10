package com.mambu.bancomambu.service.active;

import com.mambu.bancomambu.model.loan.AccountPlanDTO;
import reactor.core.publisher.Mono;

public interface AccountPlanService {
    Mono<AccountPlanDTO> accountPlan(String id, String detailsLevel);
}
