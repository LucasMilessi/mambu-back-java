package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.withdrawal.WithdrawalDTO;
import reactor.core.publisher.Mono;

public interface AddWithdrawalService {
    Mono<WithdrawalDTO> addWithdraw(String depositAccountId, WithdrawalDTO withdrawalDTO);
}
