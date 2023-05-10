package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.deposit.DepositDTO;
import reactor.core.publisher.Mono;

public interface CreateDepositService {
    Mono<DepositDTO> createDeposit(String idAccount, DepositDTO depositDTO);
}
