package com.mambu.bancomambu.service.passive;

import com.mambu.bancomambu.model.account.RequestSeizeAccountDTO;
import com.mambu.bancomambu.model.account.ResponseSeizeAccountDTO;
import reactor.core.publisher.Mono;

public interface SeizureTransactionsService {
    Mono<ResponseSeizeAccountDTO> blockAccount(String id, RequestSeizeAccountDTO requestSeizeAccountDTO);
}
