package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.ResponseSeizeAccountDTO;
import com.mambu.bancomambu.model.passiveAnnexe.BlockAndSeizeRequestDTO;
import reactor.core.publisher.Mono;

public interface BlockSeizureAccountService {
    Mono<ResponseSeizeAccountDTO> blockAndSeizeAccount(String idAccount, BlockAndSeizeRequestDTO blockAndSeizeRequestDTO);
}
